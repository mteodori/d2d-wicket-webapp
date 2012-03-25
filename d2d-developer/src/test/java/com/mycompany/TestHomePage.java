package com.mycompany;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage
{
	private WicketTester tester;

	@Before
	public void setUp()
	{
	    tester = new WicketTester(new WicketApplication() {
	        @Override
	        public void init() {
	            super.init();
                getResourceSettings().addResourceFolder("../d2d-designer/src/main/webapp");
	        }
	    });
	}

	@Test
	public void homepageRendersSuccessfully()
	{
		//start and render the test page
		tester.startPage(HomePage.class);

		//assert rendered page class
		tester.assertRenderedPage(HomePage.class);
	}
}
