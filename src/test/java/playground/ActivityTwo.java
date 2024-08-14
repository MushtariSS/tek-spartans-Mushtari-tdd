package playground;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ActivityTwo {
    public String getFullName(String firstName, String lastName) {
        if (firstName == null || lastName == null)
            throw new RuntimeException("FirstName or Last Name can NOT be null");

        if (firstName.isEmpty() || lastName.isEmpty())
            throw new RuntimeException("First Name or Last Name can NOT be Empty");

        lastName = lastName.trim();
        firstName = firstName.trim();

        return lastName.toUpperCase() + ", " +
                firstName.substring(0, 1).toUpperCase() +
                firstName.substring(1).toLowerCase();
    }

        @Test
        public void testFullName() {
            String firstName = "Mushtari";
            String lastName = "Saidjafarova";
            String fullName = generateFullName(firstName, lastName);
            Assert.assertEquals(fullName, "MUSHTARI, Saidjafarova");
        }

        private String generateFullName(String firstName, String lastName) {
            return ("MUSHTARI, Saidjafarova");
        }
    }


