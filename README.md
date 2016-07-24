# Java Doctor's Office

#### By _Scott McIntire_

## Description

A program for office administrators to track patients in a doctor's office. Here are some users stories this program fulfills:

    As an administrator, I want to add a doctor to the database with a name and specialty.
    As an administrator, I want to add a patient with their name and birthdate.
    As an administrator, I want to be able to assign a patient to a doctor for care. (Hint: Doctors will have a one-to-many relationship with their patients.)
    As a doctor, I want to see the list of patients that have been assigned to me.

Now the doctor's office has been grown to include many doctors with the same specialty. The doctors have organized themselves into specialty groups. So when an administrator wants to enter a doctor, they must first select a specialty group and then add a doctor.

    As a patient, I want to see a list of all the doctors in a particular specialty.
    As an administrator, I want to view an alphabetical list of doctors including the number of patients they see.

## Setup and Installation Requirements

  Clone the repo.  
  Run a instance of the gradle web server with 'gradle run'.  
  Navigate to localhost:4567

  Additionally, tests can be run with 'gradle test'.

  
### License

Available for use under the MIT license.
Copyright (c) 2016 **_Scott McIntire_**

  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
