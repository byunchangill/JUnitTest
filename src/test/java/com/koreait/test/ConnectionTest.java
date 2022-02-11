package com.koreait.test;

import com.koreait.junittest.Query;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConnectionTest {
    @Test
    public void queryTest() {
        assertNotNull(Query.getConn());
    }
}
