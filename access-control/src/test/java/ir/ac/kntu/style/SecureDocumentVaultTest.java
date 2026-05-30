package ir.ac.kntu.style;

import org.junit.jupiter.api.Test;
import ir.ac.kntu.AccessLevel;
import ir.ac.kntu.SecureDocumentVault;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecureDocumentVaultTest {

    @Test
    public void testViewVaultInfo_Admin() {
        SecureDocumentVault vault =
                new SecureDocumentVault("Alice", 10, 250, AccessLevel.USER);

        assertEquals("Vault Info: 10 documents, 250.0MB used",
                vault.viewVaultInfo(AccessLevel.ADMIN));
    }

    @Test
    public void testViewVaultInfo_User() {
        SecureDocumentVault vault =
                new SecureDocumentVault("Bob", 5, 120, AccessLevel.USER);

        assertEquals("Vault Info: 5 documents, 120.0MB used",
                vault.viewVaultInfo(AccessLevel.USER));
    }

    @Test
    public void testViewVaultInfo_GuestDenied() {
        SecureDocumentVault vault =
                new SecureDocumentVault("Charlie", 3, 80, AccessLevel.USER);

        assertEquals("Access Denied",
                vault.viewVaultInfo(AccessLevel.GUEST));
    }

    @Test
    public void testAddDocument_AdminSuccess() {
        SecureDocumentVault vault =
                new SecureDocumentVault("Alice", 10, 250, AccessLevel.USER);

        assertEquals("Document added. Storage Used: 300.0MB",
                vault.addDocument(50, AccessLevel.ADMIN));
    }

    @Test
    public void testAddDocument_UserSuccess() {
        SecureDocumentVault vault =
                new SecureDocumentVault("Bob", 4, 100, AccessLevel.USER);

        assertEquals("Document added. Storage Used: 130.0MB",
                vault.addDocument(30, AccessLevel.USER));
    }

    @Test
    public void testAddDocument_GuestDenied() {
        SecureDocumentVault vault =
                new SecureDocumentVault("Charlie", 2, 60, AccessLevel.USER);

        assertEquals("Access Denied",
                vault.addDocument(20, AccessLevel.GUEST));
    }

    @Test
    public void testAddDocument_InvalidSize() {
        SecureDocumentVault vault =
                new SecureDocumentVault("Alice", 5, 200, AccessLevel.USER);

        assertEquals("Invalid document size",
                vault.addDocument(0, AccessLevel.ADMIN));
    }

    @Test
    public void testRemoveDocument_AdminSuccess() {
        SecureDocumentVault vault =
                new SecureDocumentVault("Alice", 8, 250, AccessLevel.USER);

        assertEquals("Document removed. Storage Used: 150.0MB",
                vault.removeDocument(100, AccessLevel.ADMIN));
    }

    @Test
    public void testRemoveDocument_UserDenied() {
        SecureDocumentVault vault =
                new SecureDocumentVault("Bob", 6, 180, AccessLevel.USER);

        assertEquals("Access Denied",
                vault.removeDocument(50, AccessLevel.USER));
    }

    @Test
    public void testRemoveDocument_GuestDenied() {
        SecureDocumentVault vault =
                new SecureDocumentVault("Charlie", 3, 90, AccessLevel.USER);

        assertEquals("Access Denied",
                vault.removeDocument(30, AccessLevel.GUEST));
    }

    @Test
    public void testRemoveDocument_InvalidSize() {
        SecureDocumentVault vault =
                new SecureDocumentVault("Alice", 5, 200, AccessLevel.USER);

        assertEquals("Invalid document size",
                vault.removeDocument(-10, AccessLevel.ADMIN));
    }

    @Test
    public void testRemoveDocument_InvalidRemovalAmount() {
        SecureDocumentVault vault =
                new SecureDocumentVault("Alice", 2, 50, AccessLevel.USER);

        assertEquals("Invalid removal amount",
                vault.removeDocument(100, AccessLevel.ADMIN));
    }
}