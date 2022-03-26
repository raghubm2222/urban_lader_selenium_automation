package com.goutham;

public class TestData {
    private String testId;
    private String recipientName;
    private String recipientEmail;
    private String senderName;
    private String senderEmail;
    private String senderPhoneNumber;

    public TestData(String testId, String recipientName, String recipientEmail, String senderName, String senderEmail,
            String senderPhoneNumber) {
        this.testId = testId;
        this.recipientName = recipientName;
        this.recipientEmail = recipientEmail;
        this.senderName = senderName;
        this.senderEmail = senderEmail;
        this.senderPhoneNumber = senderPhoneNumber;
    }

    public String getTestId() {
        return testId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public String getSenderPhoneNumber() {
        return senderPhoneNumber;
    }

}
