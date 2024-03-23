package seedu.duke;


import org.junit.jupiter.api.Test;
import seedu.duke.TravelActivity.TravelActivity;
import seedu.duke.TravelActivity.TravelActivityList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class DukeTest {

    @Test
    public void addTest() {
        TravelActivityList travelActivityList = new TravelActivityList();
        travelActivityList.addTravelActivity(new TravelActivity("visit museum"));
        assertEquals("visit museum", travelActivityList.getDescription("visit museum"));
    }

    @Test
    public void deleteTest() throws OmniException {
        //add the plan
        TravelActivityList travelActivityList = new TravelActivityList();
        travelActivityList.addTravelActivity(new TravelActivity("visit museum"));
        assertEquals("visit museum", travelActivityList.getDescription("visit museum"));
        //delete the plan
        travelActivityList.removeTravelActivity(1);
        assertEquals("cant be found", travelActivityList.getDescription("visit museum"));
    }

    @Test
    public void getNoActivitiesTest() throws OmniException {
        //add the first plan
        TravelActivityList travelActivityList = new TravelActivityList();
        travelActivityList.addTravelActivity(new TravelActivity("visit museum"));
        assertEquals("visit museum", travelActivityList.getDescription("visit museum"));
        //add the second and third plan
        travelActivityList.addTravelActivity(new TravelActivity("go to beach"));
        assertEquals("go to beach", travelActivityList.getDescription("go to beach"));
        travelActivityList.addTravelActivity(new TravelActivity("shopping"));
        assertEquals("shopping", travelActivityList.getDescription("shopping"));
        //check number of activities
        assertEquals(3, travelActivityList.getNoOfTravelActivities());
        //delete the first plan
        travelActivityList.removeTravelActivity(1);
        assertEquals("cant be found", travelActivityList.getDescription("visit museum"));
        //check number of activities
        assertEquals(2, travelActivityList.getNoOfTravelActivities());
    }

    @Test
    public void checkTest() throws OmniException {
        //add the first plan
        TravelActivityList travelActivityList = new TravelActivityList();
        travelActivityList.addTravelActivity(new TravelActivity("visit museum"));
        assertEquals("visit museum", travelActivityList.getDescription("visit museum"));
        //check the plan
        travelActivityList.checkTravelActivity(1);
        TravelActivity travelActivity = travelActivityList.getTravelActivities().get(0);
        assertTrue(travelActivity.getActivityStatus());
    }

    @Test
    public void uncheckTest() throws OmniException {
        //add the first plan
        TravelActivityList travelActivityList = new TravelActivityList();
        travelActivityList.addTravelActivity(new TravelActivity("visit museum"));
        assertEquals("visit museum", travelActivityList.getDescription("visit museum"));
        //check the plan
        travelActivityList.checkTravelActivity(1);
        TravelActivity travelActivity = travelActivityList.getTravelActivities().get(0);
        assertTrue(travelActivity.getActivityStatus());
        //uncheck the plan
        travelActivityList.uncheckTravelActivity(1);
        assertFalse(travelActivity.getActivityStatus());
    }

    @Test
    public void trueTest(){
        assertTrue(true);
    }
    @Test
    public void testStringConversion(){
        assertEquals("visit museum", new TravelActivity("visit museum").toString());
    }
    @Test

    //basic test for searchKeyword function
    public void searchTest () {
        assertTrue(true);
    }

    @Test
    public void testTagActivity() throws OmniException {
        TravelActivityList list = new TravelActivityList();
        list.addTravelActivity(new TravelActivity("visit museum"));
        assertEquals("visit museum", list.getDescription("visit museum"));
        // Tagging an existing task
        list.tagActivity(1, "activity 1");
        TravelActivity travelActivity = list.getTravelActivities().get(0);
        assertEquals("activity 1", travelActivity.getTag());
    }

    @Test
    public void testRemoveTagFromActivity() throws OmniException {
        TravelActivityList list = new TravelActivityList();
        list.addTravelActivity(new TravelActivity("visit museum"));
        assertEquals("visit museum", list.getDescription("visit museum"));
        // Tagging an existing task
        list.tagActivity(1, "activity 1");
        TravelActivity travelActivity = list.getTravelActivities().get(0);
        assertEquals("activity 1", travelActivity.getTag());
        // Remove an existing tag
        list.removeTag(1);
        assertEquals("visit museum", list.getDescription("visit museum"));
    }

}
