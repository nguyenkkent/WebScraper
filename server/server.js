import express from "express";
// import {PORT, mongoDBURI} from "./config.js";
import mongoose from "mongoose";
import "dotenv/config";
import { parseJson } from "./parseJson.js";

const app = express();

//console.log(process.env.PORT);

//route for home page
app.get('/', (request, response)=>{
    //console.log(request);
    return response.status(200).send('Home page of our app');
});

app.get('/about', (request, response)=>{
    return response.status(200).send("Reserved section for \"about me\"");
})

parseJson("..");

//connect to mongoDB
mongoose
    .connect(process.env.mongoURL)
    .then(()=>{
        console.log('App successfully connected to database');
        app.listen(process.env.PORT, () => {
            console.log(`App is listening on port: ${process.env.PORT}`);//use backquotes for template literals
        });
    })
    .catch((error)=>{
        console.log(error);
    });
