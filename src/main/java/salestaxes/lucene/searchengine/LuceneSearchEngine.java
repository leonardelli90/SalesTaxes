package salestaxes.lucene.searchengine;
import java.io.IOException;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.TopDocs;

public class LuceneSearchEngine {

   String indexDir = System.getProperty("user.dir") + LuceneConstants.INDEX_DIR_PATH;
   String dataDir = System.getProperty("user.dir") + LuceneConstants.DATA_DIR_PATH;

   Indexer indexer;
   Searcher searcher;

   public boolean searchWord(String stringToFind) {
      LuceneSearchEngine searchEngine;
      boolean stringFound = false;
      try {
         searchEngine = new LuceneSearchEngine();
         searchEngine.createIndex();
         stringFound = searchEngine.search(stringToFind);
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ParseException e) {
         e.printStackTrace();
      }
      return stringFound;
   }
   
   private void createIndex() throws IOException {
      indexer = new Indexer(indexDir);
      indexer.createIndex(dataDir, new TextFileFilter());
      indexer.close();
   }
   private boolean search(String searchQuery) throws IOException, ParseException {
      searcher = new Searcher(indexDir);
      TopDocs hits = searcher.search(searchQuery);
      return hits.totalHits.value > 0;
   }
}