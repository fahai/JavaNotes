package org.fahai.junit;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class AssertTests {
  @Test
  public void testAssertArrayEquals() {
    byte[] expected = "trial".getBytes();
    byte[] actual = "trial".getBytes();
    org.junit.Assert.assertArrayEquals("failure - byte arrays not same", expected, actual);
  }

  @Test
  public void testAssertEquals() {
    org.junit.Assert.assertEquals("failure - strings are not equal", "text", "text");
  }

  @Test
  public void testAssertFalse() {
    org.junit.Assert.assertFalse("failure - should be false", false);
  }

  @Test
  public void testAssertNotNull() {
    org.junit.Assert.assertNotNull("should not be null", new Object());
  }

  @Test
  public void testAssertNotSame() {
    org.junit.Assert.assertNotSame("should not be same Object", new Object(), new Object());
  }

  @Test
  public void testAssertNull() {
    org.junit.Assert.assertNull("should be null", null);
  }

  @Test
  public void testAssertSame() {
    Integer aNumber = Integer.valueOf(768);
    org.junit.Assert.assertSame("should be same", aNumber, aNumber);
  }

  // JUnit Matchers assertThat
//  @Test
//  public void testAssertThatBothContainsString() {
//    org.junit.Assert.assertThat("albumen", both(containsString("a")).and(containsString("b")));
//  }
//
//  @Test
//  public void testAssertThathasItemsContainsString() {
//    org.junit.Assert.assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "three"));
//  }
//
//  @Test
//  public void testAssertThatEveryItemContainsString() {
//    org.junit.Assert.assertThat(Arrays.asList(new String[] { "fun", "ban", "net" }), everyItem(containsString("n")));
//  }
//
//  // Core Hamcrest Matchers with assertThat
//  @Test
//  public void testAssertThatHamcrestCoreMatchers() {
//    assertThat("good", allOf(equalTo("good"), startsWith("good")));
//    assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
//    assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
//    assertThat(7, not(CombinableMatcher.<Integer> either(equalTo(3)).or(equalTo(4))));
//    assertThat(new Object(), not(sameInstance(new Object())));
//  }

  @Test
  public void testAssertTrue() {
    org.junit.Assert.assertTrue("failure - should be true", true);
  }
  
  
  @Test(expected= IndexOutOfBoundsException.class) 
  public void empty() { 
       new ArrayList<Object>().get(0); 
  }
  
  @Test
  public void testExceptionMessage() {
      try {
          new ArrayList<Object>().get(0);
//          fail("Expected an IndexOutOfBoundsException to be thrown");
      } catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
//          assertThat(anIndexOutOfBoundsException.getMessage(), is("Index: 0, Size: 0"));
      }
  }
  
  
}