import mongoose from "mongoose";
//const Schema = mongoose.Schema;

const jobsSchema = new mongoose.Schema({
  rule: {
      type: String,
      required: true,
  },
  company: {
      type: String,
      required: true,
  },
  datePosted: {
      type: Date,
      required: true,
      default: Date.now,
  },
  URL: {
      type: String,
      required: true,
  },
  city: {
      type: String,
  },
  state: {
      type: String,
  },

});

export const Jobs = mongoose.model("Jobs", jobsSchema);