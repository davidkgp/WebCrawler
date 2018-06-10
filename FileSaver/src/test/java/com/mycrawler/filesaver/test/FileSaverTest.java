package com.mycrawler.filesaver.test;

import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.Optional;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mycrawler.filesaver.FileSaver;

public class FileSaverTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		try {
			//assertTrue(FileSaver.canBeSaved.test(new URL("https://78.media.tumblr.com/f67276a0241620f639fe7db0a19968c7/tumblr_inline_p3l1hel5Ju1vo5mhn_500.jpg")));
			assertTrue(FileSaver.saveFile.apply(Optional.of(new URL("https://78.media.tumblr.com/f67276a0241620f639fe7db0a19968c7/tumblr_inline_p3l1hel5Ju1vo5mhn_500.jpg"))));
			assertTrue(FileSaver.saveFile.apply(Optional.of(new URL("https://78.media.tumblr.com/82244b55cec02fa2223a5debcb848d11/tumblr_inline_p3l1i7zL1y1vo5mhn_500.jpg"))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
