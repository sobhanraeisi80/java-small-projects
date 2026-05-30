package ir.ac.kntu;

public class SecureDocumentVault {
    private static final String ACCESS_DENIED = "Access Denied";
    @SuppressWarnings("unused")
    private final String ownerName;
    private int documentCount;
    private double storageUsed;
    @SuppressWarnings("unused")
    private final AccessLevel accessLevel;
    
    public SecureDocumentVault(String ownerName, int documentCount, double storageUsed, AccessLevel accessLevel) {
        this.ownerName = ownerName;
        this.documentCount = documentCount;
        this.storageUsed = storageUsed;
        this.accessLevel = accessLevel;
    }

    public String viewVaultInfo(AccessLevel accessLevel) {
        if(accessLevel == AccessLevel.GUEST) { 
            return ACCESS_DENIED;
        } else {
            return "Vault Info: "+ documentCount +" documents, " + storageUsed + "MB" + " used";
        }
    }

    public String addDocument(double storageUsed, AccessLevel accessLevel) {
        if(accessLevel == AccessLevel.GUEST) {
            return ACCESS_DENIED;
        } else if(storageUsed <= 0) {
            return "Invalid document size";
        } else {
            this.documentCount++;
            this.storageUsed += storageUsed;
            return "Document added. Storage Used: " + this.storageUsed + "MB";
        }
    }

    public String removeDocument(double storageUsed, AccessLevel accessLevel) {
        if(accessLevel != AccessLevel.ADMIN) {
            return ACCESS_DENIED;
        } else if(this.storageUsed - storageUsed < 0) {
            return "Invalid removal amount";
        } else if(storageUsed <= 0) {
            return "Invalid document size";
        } else {
            this.documentCount--;
            this.storageUsed -= storageUsed;
            return "Document removed. Storage Used: " + this.storageUsed+ "MB";
        }
    }
}

