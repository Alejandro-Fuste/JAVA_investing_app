package com.investing_app.controllers;

import com.google.gson.Gson;
import com.investing_app.customexceptions.*;
import com.investing_app.entities.Business;
import com.investing_app.service.BusinessServices;
import io.javalin.http.Handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusinessController {
    BusinessServices businessServices;
    public BusinessController(BusinessServices businessServices){
        this.businessServices = businessServices;
    }

    public Handler createBusiness = ctx ->{
        Gson gson = new Gson();
        try {
            Business newBusiness = gson.fromJson(ctx.body(), Business.class);
            Business createdBusiness = this.businessServices.getCreateBusinessService(newBusiness);
            String createdBusinessJson = gson.toJson(createdBusiness);
            ctx.result(createdBusinessJson);
            ctx.status(201);
        } catch (Exception e) {
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };


    public Handler getBusiness = ctx -> {
        Gson gson = new Gson();
        int id = Integer.parseInt(ctx.pathParam("id"));
        try{
            Business business = this.businessServices.getBusinessByIdService(id);
            String businessJson = gson.toJson(business);
            ctx.result(businessJson);
            ctx.status(200);
        } catch (BusinessNotFound e){
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(404);
        }
    };

    public Handler getAllBusinesses = ctx -> {
        Gson gson = new Gson();
        try {
            List<Business> businesses = this.businessServices.getAllBusinessesService();
            gson = new Gson();
            String businessesJSONs = gson.toJson(businesses);
            ctx.result(businessesJSONs);
            ctx.status(200);
        } catch (BusinessNotFound e) {
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(404);
        }
    };

    public Handler getBusinessLogin = ctx -> {
        Gson gson = new Gson();
        Map<String, String> loginCredentials = gson.fromJson(ctx.body(), Map.class);
        try {
            Business businessLogin = this.businessServices.getBusinessLoginService(loginCredentials.get("username"), loginCredentials.get("password"));
            String businessLoginJson = gson.toJson(businessLogin);
            ctx.result(businessLoginJson);
            ctx.status(200);
        } catch (UsernameOrPasswordError e) {
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
        catch (Exception e) {
            HashMap<String, String> message = new HashMap<>();
            message.put("errorMessage", e.getMessage());
            ctx.result(gson.toJson(message));
            ctx.status(400);
        }
    };
}
