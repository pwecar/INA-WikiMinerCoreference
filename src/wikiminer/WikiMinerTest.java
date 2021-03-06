/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wikiminer;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.wikipedia.miner.model.Article;
import org.wikipedia.miner.model.Wikipedia;
import org.wikipedia.miner.util.WikipediaConfiguration;
import org.xml.sax.SAXException;

/**
 *
 * @author rakhmatullahyoga
 */
public class WikiMinerTest {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            WikipediaConfiguration conf = new WikipediaConfiguration(new File(WikiConstants.WIKI_CONFIG_PATH));
            conf.setDefaultTextProcessor(new TextFolder()) ;
            Wikipedia wikipedia = new Wikipedia(conf, false);
            Article article = wikipedia.getArticleByTitle("Istana Negara");
            System.out.println(article.getSentenceMarkup(0));
            wikipedia.close();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(WikiMinerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(WikiMinerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WikiMinerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WikiMinerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(WikiMinerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(WikiMinerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
