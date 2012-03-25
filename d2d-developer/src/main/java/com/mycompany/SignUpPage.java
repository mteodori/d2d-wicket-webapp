package com.mycompany;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.string.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SignUpPage extends WebPage {
    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerFactory.getLogger(SignUpPage.class);

    private User user = new User();

    private TextField<String> usernameTextField;
    private TextField<String> passwordTextField;
    private TextField<String> confirmPasswordTextField;

    @SuppressWarnings("serial")
    public SignUpPage() {
        Form<User> form = new Form<User>("form") {
            @Override
            protected void onSubmit() {
                String password = passwordTextField.getValue();
                String confirmPassword = confirmPasswordTextField.getValue();
                if (Strings.isEqual(password, confirmPassword)) {
                    user.setUsername(usernameTextField.getValue());
                    user.setPassword(password);
                    user.create();
                    logger.info("username {} created", user.getUsername());
                    info(String.format("username %s created", user.getUsername()));
                } else {
                    error("password do not match");
                }
            }
        };
        form.add(usernameTextField = new EmailTextField("username", Model.of("")));
        form.add(passwordTextField = new PasswordTextField("password", Model.of("")));
        form.add(confirmPasswordTextField = new PasswordTextField("confirmPassword", Model.of("")));
        form.add(new FeedbackPanel("errors"));
        add(form);
    }

}
