package bscg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class FormatterUtilTest {

	FormatterUtil formatterUtil;

	@Before
	@Test
	public void setup() {
		// some fixtures
		formatterUtil = new FormatterUtil();

		FormatterUtil.addToStartWithList("56");
		FormatterUtil.addToStartWithList("56"); // method ignores duplicates
		FormatterUtil.addToStartWithList("4519");

		FormatterUtil.addToEndWithList("345");
		FormatterUtil.addToEndWithList("345"); // method ignores duplicates

//		 formatterUtil.createNewCard("HSBC Canada", "5601-2345-3446-5678",
//		 "Nov-2017");
	}

	@Test
	public void test_getStartWithList() {
		
	}		
	
	@Test
	public void test_getEndWithList() {
		assertEquals("Ending with  : [345]","Ending with  : "+ FormatterUtil.getEndWithList());
	}		
	
	@Test
	public void test_deleteStartWithList() {
		FormatterUtil.deleteEntryFromStartWithList("4519");
		assertEquals("Starting with: [56]","Starting with: "+ FormatterUtil.getStartWithList());
	}		
	

	@Test
	public void test_deleteEndWithList() {
		FormatterUtil.deleteEntryFromEndtWithList("345");
		assertEquals("Ending with: []","Ending with: "+ FormatterUtil.getEndWithList());
	}		
	
	
	@Test
	public void test_addToStartWithList() {
		ArrayList<String> startWithList = FormatterUtil.getStartWithList();
		assertTrue(startWithList.contains("56")); // method ignores duplicates
		System.out.println(FormatterUtil.getStartWithList());
	}

	@Test
	public void test_addToEndWithList() {
		ArrayList<String> endWithList = FormatterUtil.getEndWithList();
		assertTrue(endWithList.contains("345")); // method ignores duplicates
		System.out.println(FormatterUtil.getEndWithList());
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void test_formatStringToSimpleDate() throws ParseException {
		Date expiryDate = FormatterUtil.formatStringToSimpleDate("Nov-2017");
		assertEquals("Wed Nov 01 00:00:00 GMT 2017", expiryDate.toString());
	}

	@Test
	public void test_fromatSimpleDateToString() throws ParseException {
		Date expiryDate = FormatterUtil.formatStringToSimpleDate("Nov-2017");
		String stringExpirayDate = FormatterUtil.formatSimpleDateToString(expiryDate);
		System.out.println(stringExpirayDate);
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	
	@Test
	@Ignore
	public void test_formatCardNumber() {
		String formatedCardNumber = FormatterUtil.formatCardNumber("5601-2345-3446-345 ", "", "345 ");
		assertEquals("xxxx-xxxx-xxxx-345", formatedCardNumber);
		formatedCardNumber = FormatterUtil.formatCardNumber("5601-2345-3446-345", "","345");
		assertEquals("xxxx-xxxx-xxxx-345", formatedCardNumber);
		formatedCardNumber = FormatterUtil.formatCardNumber("4519-2345-3446-345","4519", null);
		assertEquals("4519-xxxx-xxxx-xxx", formatedCardNumber);
		formatedCardNumber = FormatterUtil.formatCardNumber("5601-2345-3446-345", "56","");
		assertEquals("56xx-xxxx-xxxx-xxx", formatedCardNumber);
	}

	@Test
	public void test_formatCard() {
		FormatterUtil.addToStartWithList("4519"); // method ignores duplicates
		String formatedCard = FormatterUtil.formatCard("5601-2345-3446-345");
		System.out.println(formatedCard);
		formatedCard = FormatterUtil.formatCard("4519-2345-3446-3345");
		System.out.println(formatedCard);
		assertEquals("4519-xxxx-xxxx-xxxx", formatedCard);

		FormatterUtil.addToEndWithList("345"); // method ignores duplicates
		formatedCard = FormatterUtil.formatCard("3301-2345-3446-345");
		System.out.println(formatedCard);
		assertEquals("xxxx-xxxx-xxxx-345", formatedCard);
	}	
	
	//////////////////////////////////////////////////////////////////////////////////
	
}
