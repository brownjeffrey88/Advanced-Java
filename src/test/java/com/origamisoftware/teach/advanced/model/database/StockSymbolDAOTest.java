package com.origamisoftware.teach.advanced.model.database;

import com.origami.teach.model.database.StockSymbolDAO;
import util.DatabaseUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 *  Verify the stockSymbolDAO class
 */
public class StockSymbolDAOTest extends AbstractBaseDAOTest {

    @Test
    public void testRead() {
        StockSymbolDAO stockSymbolDAO = DatabaseUtils.findUniqueResultBy("symbol", "APPL",
                StockSymbolDAO.class, true);
        assertTrue("APPL StockSymbolDAO found", stockSymbolDAO.getId() == 1);
    }


}
