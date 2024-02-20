import express from "express";
import {PORT, mongoDBURI} from "./config.js";
import mongoose from "mongoose";

const app = express();

// app.listen(PORT, () => {
//     console.log(`App is listening on port: ${PORT}`);//use backquotes for template literals
// });

app.get('/', (request, response)=>{
    //console.log(request);
    return response.status(234).send('Home page of our app');
});

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
