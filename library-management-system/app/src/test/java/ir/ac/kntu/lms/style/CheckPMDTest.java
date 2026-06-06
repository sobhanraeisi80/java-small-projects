package ir.ac.kntu.lms.style;

import java.nio.file.Path;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

// ایمپورت‌های کاملاً دقیق و رسمی توزیع نهایی PMD 7.1.0
import net.sourceforge.pmd.PMDConfiguration;
import net.sourceforge.pmd.PmdAnalysis;
import net.sourceforge.pmd.lang.LanguageRegistry;
import net.sourceforge.pmd.lang.rule.RulePriority;
import net.sourceforge.pmd.reporting.Report;
import net.sourceforge.pmd.reporting.RuleViolation;

public class CheckPMDTest {

    @Test
    public void testPMD() {
        PMDConfiguration config = new PMDConfiguration();

        // دسترسی استاندارد به موتور قوانین نسخه 7
        config.setDefaultLanguageVersion(LanguageRegistry.PMD.getLanguageById("java").getDefaultVersion());
        
        String projectDir = System.getProperty("projectDir", ".");
        config.addInputPath(Path.of(projectDir, "src/main/"));
        config.setMinimumPriority(RulePriority.LOW);
        config.addRuleSet("ir/ac/kntu/style/ruleset.xml");
        config.setReportFormat("text");
        config.setIgnoreIncrementalAnalysis(true);

        try (PmdAnalysis pmd = PmdAnalysis.create(config)) {
            Report report = pmd.performAnalysisAndCollectReport();
            List<RuleViolation> violations = report.getViolations();

            System.out.println("Found " + violations.size() + " PMD rule violations.");
            assertEquals(0, violations.size(), violations.size() + " PMD rule violations found.");
        }
    }
}