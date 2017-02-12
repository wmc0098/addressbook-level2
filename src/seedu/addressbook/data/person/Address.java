package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address extends Contact{

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = 
            "Person addresses should be written as a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    //private final String value;
    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;
    
    private static final int INDEX_ADDRESS_BLOCK = 0;
    private static final int INDEX_ADDRESS_STREET = 1;
    private static final int INDEX_ADDRESS_UNIT = 2;
    private static final int INDEX_ADDRESS_POSTAL_CODE = 3;
    private static final int ADDRESS_VALIDATION_LENGTH = 4;
    

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        super(address, isPrivate);
        String[] addressParts = this.value.split(",");
        if (!isValidAddress(this.value, addressParts.length)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.block = new Block(addressParts[INDEX_ADDRESS_BLOCK]);
        this.street = new Street(addressParts[INDEX_ADDRESS_STREET]);
        this.unit = new Unit(addressParts[INDEX_ADDRESS_UNIT]);
        this.postalCode = new PostalCode(addressParts[INDEX_ADDRESS_POSTAL_CODE]);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test, int stringParts) {
        // this should check if the address contains 4 parts and whether the 4 parts follow their rules
        //current implementation allows for any string
        return test.matches(ADDRESS_VALIDATION_REGEX) && stringParts==ADDRESS_VALIDATION_LENGTH;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.block.getBlock()).append(',')
                .append(this.street.getStreet()).append(',')
                .append(this.unit.getUnit()).append(',')
                .append(this.postalCode.getPostalCode())
                .toString();
    }

    /**
     * @return the value
     */
    public String getAddressValue() {
        return this.toString();
    }

    @Override
    public String getPrintableString() {
        return "Address: " + this.toString();
    }
}
