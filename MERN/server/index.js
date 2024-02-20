import express from "express";
import {PORT, mongoDBURI} from "./config.js";
import mongoose from "mongoose";

const app = express();

//route for home page
app.get('/', (request, response)=>{
    //console.log(request);
    return response.status(200).send('Home page of our app');
});

app.get('/about', (request, response)=>{
    return response.status(200).send("Reserved section for \"about me\"");
})

//connect to mongoDB
mongoose
    .connect(mongoDBURI)
    .then(()=>{
        console.log('App successfully connected to database');
        app.listen(PORT, () => {
            console.log(`App is listening on port: ${PORT}`);//use backquotes for template literals
        });
    })
    .catch((error)=>{
        console.log(error);
    });
