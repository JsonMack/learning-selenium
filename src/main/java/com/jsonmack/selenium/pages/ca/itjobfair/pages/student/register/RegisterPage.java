package com.jsonmack.selenium.pages.ca.itjobfair.pages.student.register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.openqa.selenium.support.How.*;

/**
 * @author Jason MacKeigan
 *
 * The registration page for the it job fair website. This ues the page object model
 * pattern which allows us to reduce duplicate testing code.
 */
public class RegisterPage {

    @FindBy(how = NAME, name = "studentForm")
    private WebElement form;

    @FindBy(how = NAME, name = "w_number")
    @CacheLookup
    private WebElement studentId;

    @FindBy(how = How.NAME, name = "first_name")
    @CacheLookup
    private WebElement firstName;

    @FindBy(how = How.NAME, name = "last_name")
    @CacheLookup
    private WebElement lastName;

    @FindBy(how = How.NAME, name = "program_id")
    @CacheLookup
    private WebElement program;

    @FindBy(how = How.NAME, name = "campus")
    @CacheLookup
    private WebElement campus;

    @FindBy(how = How.NAME, name = "grad_year")
    @CacheLookup
    private WebElement gradYear;

    @FindBy(how = How.ID, id = "mentor_requested_yes")
    private WebElement mentorRequestedYes;

    @FindBy(how = How.ID, id = "mentor_requested_no")
    private WebElement mentorRequestedNo;

    @FindBy(how = How.ID, id = "share_information_yes")
    private WebElement shareInformationYes;

    @FindBy(how = How.ID, id = "share_information_no")
    private WebElement shareInformationNo;

    @FindBy(how = How.ID, id = "special_projects_yes")
    private WebElement specialProjectsYes;

    @FindBy(how = How.ID, id = "special_projects_no")
    private WebElement specialProjectsNo;

    @FindBy(how = How.ID, id = "include_portfolio_links_yes")
    private WebElement includePortfolioLinksYes;

    @FindBy(how = How.ID, id = "include_portfolio_links_no")
    private WebElement includePortfolioLinksNo;

    @FindBy(how = How.NAME, name = "portfolio_link[]")
    private List<WebElement> portfolioLinks;

    @FindBy(how = How.ID, id = "add_portfolio_link")
    private WebElement addPortfolioLink;

    @FindBy(how = How.ID, id = "submit")
    @CacheLookup
    private WebElement submit;

    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Fills out the form in its entirety. This does not submit it however. To submit, call {@link #submit()}.
     *
     * @param studentId
     *            the student id number, this must start with a 'w' to be successful.
     * @param firstName
     *            the first name of the student.
     * @param lastName
     *            the last name of the student.
     * @param campus
     *            the campus that the student is enrolled in.
     * @param gradYear
     *            the year that the student will be graduating.
     * @param program
     *            the program the student is enrolled in.
     * @param shareInformation
     *            a boolean indicating whether the student wants to share their information with industry.
     * @param specialProjects
     *            a boolean indicated whether the student wants to participate in special projects.
     * @param mentorRequested
     *            a boolean indicating whether or not the student wants a mentor.
     * @param includePortfolioLinks
     *            a boolean indicating whether or not the student wants to include portfolio links.
     * @param portfolioLinks
     *            a list of the students links that can be seen as portfolio links.
     */
    public void fill(String studentId, String firstName, String lastName, String campus, String gradYear, String program,
                     boolean shareInformation, boolean specialProjects, boolean mentorRequested, boolean includePortfolioLinks,
                     List<String> portfolioLinks) {
        if (portfolioLinks.size() > this.portfolioLinks.size()) {
            throw new IllegalArgumentException(String.format("The links provided cannot exceed the amount of elements available. " +
                            "Expected a max of %d and got %d.", this.portfolioLinks.size(), portfolioLinks.size()));
        }
        this.studentId.sendKeys(studentId);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.program.sendKeys(program);
        this.campus.sendKeys(campus);
        this.gradYear.sendKeys(gradYear);
        this.toggleMentorRequested(mentorRequested);
        this.toggleSpecialProjects(specialProjects);
        this.toggleShareInformation(shareInformation);
        this.toggleIncludePortfolioLinks(includePortfolioLinks);
        this.fillPortfolioLinks(portfolioLinks);
    }

    /**
     * Toggles the button that determines if the student wants a mentor.
     *
     * @param requested
     *            if true, the student will receive communication from a mentor.
     */
    public void toggleMentorRequested(boolean requested) {
        WebElement element = requested ? mentorRequestedYes : mentorRequestedNo;

        element.click();
    }

    /**
     * Toggles the button that determines if the student wants to participate in special projects.
     *
     * @param specialProjects
     *            if true, the student wants to participate in special projects.
     */
    public void toggleSpecialProjects(boolean specialProjects) {
        WebElement element = specialProjects ? specialProjectsYes : specialProjectsNo;

        element.click();
    }

    /**
     * Toggles the button that determines if the student wants to share information with industry.
     *
     * @param shareInformation
     *            if true, the student wants to share information with industry.
     */
    public void toggleShareInformation(boolean shareInformation) {
        WebElement element = shareInformation ? shareInformationYes : shareInformationNo;

        element.click();
    }

    /**
     * Toggles the button that determines if the student wants to include portfolio links.
     *
     * @param includePortfolioLinks
     *            if true, portfolio links will be available for insertion.
     */
    public void toggleIncludePortfolioLinks(boolean includePortfolioLinks) {
        WebElement element = includePortfolioLinks ? includePortfolioLinksYes : includePortfolioLinksNo;

        element.click();
    }

    /**
     * Fills the portfolio links in the form.
     *
     * @param links
     *            the links the student wants to include.
     */
    public void fillPortfolioLinks(List<String> links) {
        for (int index = 0; index < links.size(); index++) {
            String link = links.get(index);

            portfolioLinks.get(index).sendKeys(link);

            if (index == links.size() - 1) {
                continue;
            }
            addPortfolioLink.click();
        }
    }

    /**
     * Submits the form by calling submit on the {@link #form} object. This could
     * alternatively be done through the submit button.
     */
    public void submit() {
        form.submit();
    }
}
