package com.jsonmack.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import static org.openqa.selenium.support.How.*;

/**
 * @author Jason MacKeigan
 */
public class RegisterPage {

    @FindBy(how = NAME, name = "studentForm")
    private WebElement form;

    @FindBy(how = NAME, name = "w_number")
    private WebElement studentId;

    @FindBy(how = How.NAME, name = "first_name")
    private WebElement firstName;

    @FindBy(how = How.NAME, name = "last_name")
    private WebElement lastName;

    @FindBy(how = How.NAME, name = "program_id")
    private WebElement program;

    @FindBy(how = How.NAME, name = "campus")
    private WebElement campus;

    @FindBy(how = How.NAME, name = "grad_year")
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
    private WebElement submit;

    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fill(String studentId, String firstName, String lastName, String campus, String gradYear, String program,
                     boolean shareInformation, boolean specialProjects, boolean mentorRequested, boolean includePortfolioLinks,
                     List<String> portfolioLinks) {
        this.studentId.sendKeys(studentId);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);

        Select programSelect = new Select(this.program);

        programSelect.selectByValue(program);

        Select campusSelect = new Select(this.campus);

        campusSelect.selectByValue(campus);

        Select gradYearSelect = new Select(this.gradYear);

        gradYearSelect.selectByValue(gradYear);

        if (mentorRequested) {
            mentorRequestedYes.click();
        } else {
            mentorRequestedNo.click();
        }

        if (specialProjects) {
            specialProjectsYes.click();
        } else {
            specialProjectsNo.click();
        }

        if (shareInformation) {
            shareInformationYes.click();
        } else {
            shareInformationNo.click();
        }

        if (includePortfolioLinks) {
            includePortfolioLinksYes.click();
        } else {
            includePortfolioLinksNo.click();
        }
        Queue<String> links = new ArrayDeque<>(portfolioLinks);

        this.portfolioLinks.get(0).sendKeys(links.poll());

        this.addPortfolioLink.click();

        this.portfolioLinks.get(1).sendKeys(links.poll());

        this.addPortfolioLink.click();

        this.portfolioLinks.get(2).sendKeys(links.poll());
    }

    public void submit() {
        form.submit();
    }

    public WebElement getStudentId() {
        return studentId;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getProgram() {
        return program;
    }

    public WebElement getCampus() {
        return campus;
    }

    public WebElement getGradYear() {
        return gradYear;
    }

    public WebElement getMentorRequestedYes() {
        return mentorRequestedYes;
    }

    public WebElement getMentorRequestedNo() {
        return mentorRequestedNo;
    }

    public WebElement getShareInformationYes() {
        return shareInformationYes;
    }

    public WebElement getShareInformationNo() {
        return shareInformationNo;
    }

    public WebElement getIncludePortfolioLinksYes() {
        return includePortfolioLinksYes;
    }

    public WebElement getIncludePortfolioLinksNo() {
        return includePortfolioLinksNo;
    }

    public List<WebElement> getPortfolioLinks() {
        return portfolioLinks;
    }

    public WebElement getAddPortfolioLink() {
        return addPortfolioLink;
    }

    public WebElement getSubmit() {
        return submit;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getSpecialProjectsYes() {
        return specialProjectsYes;
    }

    public WebElement getSpecialProjectsNo() {
        return specialProjectsNo;
    }
}
