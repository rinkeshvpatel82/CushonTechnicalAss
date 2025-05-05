package pages;


import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    // String Locator - OR
    private String emailId="//input[@id='exampleInputEmail']";
    private String emailFieldError=".invalid-feedback.invalid-email";
    private String password="//input[@id='exampleInputPassword']";
    private String passwordFieldError=".invalid-feedback.invalid-password";
    private String loginBtnLink="a:text('Login')";
    private String loginBtn="[type='submit']";
    private String headerText=".display-3";
    // page constructor
    public LoginPage(Page page){
        this.page=page;
    }

    // page Action

    public String getPageHeaderText(){
        return page.textContent(headerText);
    }

    public void loginLinkClick(){
        page.click(loginBtnLink);
    }
    public void loginButtonClick(){
        page.click(loginBtn);
    }
    public String emailFieldError(){
        return page.textContent(emailFieldError).trim();
    }
    public String passwordFieldError(){
        return page.textContent(passwordFieldError);
    }
    public boolean doLogin(String appUserName, String appUserPassword){
        System.out.println( "App creds: "+ appUserName + ":" + appUserPassword);
        page.fill(emailId,appUserName);
        page.fill(password,appUserPassword);
        page.click(loginBtn);
        if(page.textContent(headerText).equals("Your Account")){
            System.out.println("user is logged in successfully....!");
            return true;
        }else {
            return false;
        }
    }

    public void enterTheCredentials(String appUserName, String appUserPassword){
        System.out.println( "App creds: "+ appUserName + ":" + appUserPassword);
        page.fill(emailId,appUserName);
        page.fill(password,appUserPassword);
        page.click(loginBtn);
    }

}
