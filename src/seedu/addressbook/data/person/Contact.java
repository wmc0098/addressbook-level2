package seedu.addressbook.data.person;

public class Contact {
    
    protected String value;
    protected boolean isPrivate;
    
    public Contact(String value, boolean isPrivate) {
        this.isPrivate = isPrivate;
        String trimmedValue = value.trim();
        this.value = trimmedValue;
    }
    
    @Override
    public String toString() {
        return value;
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }
    
    @Override
    public int hashCode() {
        return value.hashCode();
    }

    /**
     * @return the isPrivate
     */
    public boolean isPrivate() {
        return isPrivate;
    }

}
