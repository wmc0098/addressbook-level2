package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;

import java.util.List;
//import java.util.Optional;

public class TextFormatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;


    public static String getUserInput() {
        return LINE_PREFIX + "Enter command: ";
    }
    
    public static String echoUserInput(String input) {
        return "[Command entered:" + input + "]";
    }

    public static String getWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        return formatMessage(DIVIDER,
                DIVIDER,
                MESSAGE_WELCOME,
                version,
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                storageFileInfo,
                DIVIDER);
    }
    
    
    private static String formatMessage(String... message) {
        StringBuilder formattedString = new StringBuilder();
        for (String m : message) {
            formattedString .append(LINE_PREFIX + m.replace("\n", LINE_SEPARATOR + LINE_PREFIX)).append("\n");
        }
        return formattedString.toString();
    }

    public static String getGoodbyeMessage() {
        // TODO Auto-generated method stub
        return formatMessage(MESSAGE_GOODBYE, DIVIDER, DIVIDER);
    }

    public static String getInitFailedMessage() {
        // TODO Auto-generated method stub
        return formatMessage(MESSAGE_INIT_FAILED, DIVIDER, DIVIDER);
    }
    
    public static String formatCommandResult(String result) {
        // TODO Auto-generated method stub
        return formatMessage(result, DIVIDER);
    }
    
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatMessage(formatted.toString());
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

}
