package com.argosenpaikun.risa.stdout;

/**
 * Author: Mohamed Affian bin Che Mohamed Onn
 * Date: 13/11/2020
 * Company: Dataran Teknologi Sdn. Bhd.
 */

import com.argosenpaikun.risa.args.StdOut;
import com.argosenpaikun.risa.utils.CharUtil;
import com.argosenpaikun.risa.utils.data.CSV;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * This class is for testing the standard output
 */
public class StdOutTest {

    CharUtil charUtil;
    CSV csv;

    @Before
    public void setup() {
        // initialize singleton
        charUtil = CharUtil.getInstance();
        csv = CSV.getInstance();
    }

    @Test
    public void hello_world_toupper() {
        String value = "hello world";
        assertEquals(charUtil.toUpper(value), "HELLO WORLD");
    }

    @Test
    public void hello_world_alternate() {
        String value = "hello world";

        List<Boolean> cs = new ArrayList<>();
        cs.add(false);  // h
        cs.add(true);   // e
        cs.add(false);  // l
        cs.add(true);   // l
        cs.add(false);  // o
        cs.add(false);  //
        cs.add(false);  // w
        cs.add(true);   // o
        cs.add(false);  // r
        cs.add(true);   // l
        cs.add(false);  // d

        // if size is more than value length
        // in case, if the length of case selector is bigger then value length,
        // just to make it efficiently work
        if(cs.size() > value.length()) {
            while (cs.size() > value.length()) {
                cs.remove(cs.size() - 1);
            }
        } else if(cs.size() < value.length()) {
            while (cs.size() < value.length()) {
                cs.add(false);
            }
        }

        assertEquals(charUtil.alternateCharCase(value, cs), "hElLo wOrLd");
    }

    @Test
    public void hello_world_csv() {
        String value = "hello world";

        try {
            csv.writeData(new ArrayList<>(Collections.singletonList(charUtil.stringToCharAt(value))),
                    "hello-world.csv");

            assertTrue(new File("hello-world.csv").exists());
            assertEquals(new BufferedReader(new FileReader("hello-world.csv")).readLine(),
                    "h,e,l,l,o, ,w,o,r,l,d");
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
