package xmu.sspo.service.impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.FacetParams;

import xmu.sspo.model.Text;

public class SolrTest {
	private final static String SOLR_URL = "http://localhost:8080/solr/";  
	 
    private String solrCore="collection1";//ָ���Ĵ洢���ݵ�collection
    /**
     * ����SolrServer����
     * 
     * �ö�������������ʹ�ã������̰߳�ȫ��  
     * 1��CommonsHttpSolrServer������web������ʹ�õģ�ͨ��http����� 
     * 2�� EmbeddedSolrServer����Ƕʽ�ģ�����solr��jar���Ϳ���ʹ����  
     * 3��solr 4.0֮���������˲��ٶ���������CommonsHttpSolrServer��������ΪHttpSolrClient
     * 
     * @return
     */
    public HttpSolrClient createSolrServer(){
        HttpSolrClient solr = null;
        solr = new HttpSolrClient(SOLR_URL);
        solr.setConnectionTimeout(100);  
        solr.setDefaultMaxConnectionsPerHost(100);  
        solr.setMaxTotalConnections(100); 
        return solr;
    }
    /**
     * ��ѯ
    * @throws Exception 
     */
    public void querySolr() throws Exception{
        HttpSolrClient solrServer = new HttpSolrClient(SOLR_URL+solrCore);  
        SolrQuery query = new SolrQuery();  
        //��������solr��ѯ����
//        query.set("q", "*:*");// ����q  ��ѯ����   
//        query.set("q","*Ӣ��*");//��ز�ѯ������ĳ������ĳ���ֶκ����ܡ��ǡ���������  �����ѯ���� ��������������������ѯ
 
        //����fq, ��query���ӹ��˲�ѯ����  
//        query.addFilterQuery("id:[0 TO 9]");//idΪ0-9  
 
        //��query���Ӳ�����������  
        //query.addFilterQuery("description:��Ա");  //description�ֶ��к��С���Ա�����ֵ�����
 
        //����df,��query����Ĭ��������  
//        query.set("df", "name");  
        
//        query.setQuery("id:");
        query.setQuery("content:*Ӣ��* OR content:*����*" );
//        query.setQuery("content:*Ӣ��* AND content:*����*" );
        
        
        //�����ѯ
        query.setFacet(true);
        query.addFacetField("content","id");//�������и��Զ����Ľ��
        /*
         * FacetComponet����������ѡ�񣬷ֱ���count��index��
         * count�ǰ�ÿ���ʳ��ֵĴ�����index�ǰ��ʵ��ֵ�˳�������ѯ������ָ��facet.sort��solrĬ���ǰ�count����
         */
        query.setFacetSort(FacetParams.FACET_SORT_COUNT);
        /*query.setFacetLimit(101);  */ // ���÷��ؽ������ ,-1��ʾ��������,Ĭ��ֵΪ100
        /* query.setParam(FacetParams.FACET_OFFSET, "100");*/   //��ʼ����,ƫ����,����facet.limit���ʹ�ÿ��Դﵽ��ҳ��Ч��
        query.setFacetMinCount(1);//���� ���� count����С����ֵ��Ĭ��Ϊ0 
        query.setFacetMissing(false);//��ͳ��null��ֵ
        /* query.setFacetPrefix("test");//����ǰ׺ */
 
        
        
        //����sort,���÷��ؽ�����������  
//        query.addSort("id",SolrQuery.ORDER.asc);
//        query.addSort("name", SolrQuery.ORDER.desc);
 
        //���÷�ҳ����  
//        query.setStart(0);  
//        query.setRows(10);//ÿһҳ����ֵ  
 
        //����hl,���ø���  
        query.setHighlight(true);  
        //���ø������ֶ�  
        query.addHighlightField("name");  
        //���ø�������ʽ  
        query.setHighlightSimplePre("<font color='red'>");  
        query.setHighlightSimplePost("</font>"); 
 
        //��ȡ��ѯ���
        QueryResponse response = solrServer.query(query);  
        //���ֽ����ȡ���õ��ĵ����ϻ���ʵ�����
        
        // ��ȡ�������ݽ��
        //Map<String, Map<String, List<String>>> map = response.getHighlighting();
 
        // �õ�FacetField���
        System.out.println(response.getFacetFields());
        
        //��ȡ�������ݽ��
        System.out.println("�������ݽ��"+response.getHighlighting());
        
        //��ѯ�õ��ĵ��ļ���  
        SolrDocumentList solrDocumentList = response.getResults();  
        System.out.println("ͨ���ĵ����ϻ�ȡ��ѯ�ĵ�������"+solrDocumentList.getNumFound()); 
        //�����б�  
        for (SolrDocument doc : solrDocumentList) {
            System.out.println("id:"+doc.get("id")+"   content:"+doc.get("content"));
        } 
        
        //�õ�ʵ�����
        List<Text> tmpLists = response.getBeans(Text.class);
        if(tmpLists!=null && tmpLists.size()>0){
            System.out.println("ʵ�����ֵ���ݣ�"); 
            for(Text per:tmpLists){
                System.out.println(per.toString());
            }
        }
    }
 
    
    public static void main(String[] args) throws Exception {
        SolrTest solr = new SolrTest();
        solr.querySolr();
   }
 
}
