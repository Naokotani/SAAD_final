/**
 * Created names and contains methods for return name strings in different formats.
 */
public class Name {
    // Can String that can be one or more first names or given names. Optional
    private String givenName;
    // Middle name, opptional
    private String middleName;
    // Last name/s optional
    private String lastName;

    /**
     * Constructor for Name class. At least one of the parameters must be not empty.
     * @param givenName Can be a string contain a name/s or be empty
     * @param middleName Can be a string contain a name/s or be empty
     * @param lastName Can be a string contain a name/s or be empty
     * @throws Exception Throws an exception lf all parameters are empty strings.
     */
    public Name(String givenName, String middleName, String lastName) throws Exception{

        if (givenName.isEmpty() && middleName.isEmpty() && lastName.isEmpty()) {
            throw new Exception("At least one name must be filled out");
        }

        this.givenName = givenName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    /**
     * @return Returns a name string that starts with the last name if it is not an empty string.
     */
    public String getLastFirst() {
        if (!this.lastName.isEmpty()) {
            return this.lastName + ", " + this.givenName + " " + this.middleName;
        } else {
            return this.givenName + " " + this.middleName;
        }

    }

    /**
     * Overrides the default to string method
     * @return Returns a name string starting with the given name/s.
     */
    @Override
    public String toString() {
        return givenName + " " + middleName + " " +  lastName;
    }
}
