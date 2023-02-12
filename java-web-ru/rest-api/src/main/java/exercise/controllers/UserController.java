package exercise.controllers;

import io.javalin.core.validation.BodyValidator;
import io.javalin.core.validation.JavalinValidation;
import io.javalin.core.validation.ValidationError;
import io.javalin.core.validation.Validator;
import io.javalin.http.Context;
import io.javalin.apibuilder.CrudHandler;
import io.ebean.DB;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import exercise.domain.User;
import exercise.domain.query.QUser;

import org.apache.commons.validator.routines.EmailValidator;

public class UserController implements CrudHandler {

    public void getAll(Context ctx) {
        // BEGIN
        List<User> users = new QUser()
                .orderBy()
                .id
                .asc()
                .findList();
        String json = DB.json().toJson(users);
        ctx.json(json);
        // END
    }

    ;

    public void getOne(Context ctx, String id) {

        // BEGIN
        User user = new QUser()
                .id
                .equalTo(Integer.parseInt(id))
                .findOne();
        String json = DB.json().toJson(user);
        ctx.json(json);
        // END
    }

    ;

    public void create(Context ctx) {

        // BEGIN
        String body = ctx.body();
        BodyValidator<User> u = ctx.bodyValidator(User.class)
                .check(it->EmailValidator.getInstance().isValid(it.getEmail()), "email not valid");
        if(!(u.errors().isEmpty())){
            ctx.redirect("/api/v1/users");
            return;
        }
        //User user = DB.json().toBean(User.class, body);
        //user.save();
        u.get().save();
        ctx.status(200);
        // END
    }

    ;

    public void update(Context ctx, String id) {
        // BEGIN
        String body = ctx.body();
        User user = DB.json().toBean(User.class, body);
        user.setId(id);
        user.update();
        ctx.status(200);
        // END
    }

    ;

    public void delete(Context ctx, String id) {
        // BEGIN
        String body = ctx.body();
        User user = DB.json().toBean(User.class, body);
        user.setId(id);
        user.delete();
        // END
    }

    ;
}
