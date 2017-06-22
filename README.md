#Smart Recruitment Automation Engine

[![License](http://img.shields.io/badge/license-MIT-brightgreen.svg)](http://opensource.org/licenses/MIT)

An attempt to completely automate the Recruitment process. This piece of code successfully gives us the basic contact information, skills, experience etc., from any document (Job Description/CV/Resume) independent of the document format. I would like to implement some deeplearning algo's to take this project to next level. PR's are most welcomed!

## Pre-requisites

Java, Apache Opennlp

## Flow

This src contains two packages:

**1. pacakge dota**

This package contains all the classes required to parse a document(Job Description or CV) and gives the extracted entitites which is done with the help of using 
Apache Tika and Apache Opennlp.

All the resources are added to the resources folder i.e., all the model files(.bin files), text files etc required.

**2. package training**

This package contains all the classes to train a model with different resources we have.

To create a model, we need to have the training data placed in the respective folder. 

All the code is self explanatory and commented wherever necessary. 

Please use the issue feature to report any bug or any other issues. Feel free to [write to me](abhishek.bagati@gmail.com) in case of any doubts.

## Contributions are welcome

As I said already, I would like to implement some deeplearning algo's to take this project to next level. Please feel free to share any ideas and also, you can contribute to automate a lot of stuff.

## MIT License

Copyright (c) 2017 Abhishek Bagati

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.




 
