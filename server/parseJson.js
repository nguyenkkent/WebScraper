import fs from "fs";
import path from "path";
import { fileURLToPath } from 'url';
import { Jobs } from "./models/jobsSchema.js";
import mongoose from "mongoose";

export function parseJson(relativePath) {
  console.log("relative path: ", relativePath);
  const __filename = fileURLToPath(import.meta.url);
  const __dirname = path.dirname(__filename);

  //convert relative path to absolute path
  const absolutePath = path.resolve(__dirname, relativePath);
  console.log("absolute path: ", absolutePath);

  fs.readFile(absolutePath,'utf8', async (error, data) => {
  if (error){
      console.log(error);
      return;
  }

  // console.log(data);

  //split the data up into individual lines
  const lines = data.split("\n")
  try{
    //iterate through each line
    for (const line of lines){
      if (line.length > 0){
        //turn each line into a JSON object/document
        const jsonLine = JSON.parse(line);

        //console.log("JSON line after parse: ", jsonLine);

        const job = {
          role: jsonLine .role,
          company: jsonLine .company,
          datePosted: new Date(jsonLine .datePosted),
          URL: jsonLine .URL,
          city: jsonLine .city,
          state: jsonLine .state                    
        }
        //check if job is a duplicate
        const existingJob = await Jobs.findOne({
          role: job.role,
          company: job.company,
          datePosted: job.datePosted,
          URL: job.URL
        });

        if (!existingJob) {
          const result = await Jobs.collection.insertOne(job);
          console.log(`Job inserted successfully: ${result.insertedId}`);
        } 
        else {
          console.log("Job already exists");
        }
      }
    }
  }catch(error){
      console.log("parseJson error", error);
  }
  });

}