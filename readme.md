
# Elearning



<!--- If we have only one group/collection, then no need for the "ungrouped" heading -->



## Endpoints

* [Materi](#materi)
    1. [Get All Materi](#1-get-all-materi)
    1. [Insert New Materi](#2-insert-new-materi)
    1. [New Request](#3-new-request)
    1. [Update Data Materi](#4-update-data-materi)
* [ClassRoom](#classroom)
    1. [Insert Room](#1-insert-room)
    1. [Get All Data Room Class](#2-get-all-data-room-class)
    1. [Delete Room](#3-delete-room)
    1. [Update Room](#4-update-room)
    1. [FindRoomClassById](#5-findroomclassbyid)
* [Score](#score)
    1. [Get All Score](#1-get-all-score)
    1. [Insert New Score](#2-insert-new-score)
    1. [Find Student Score](#3-find-student-score)
    1. [Find Score By Class And Subject](#4-find-score-by-class-and-subject)
    1. [Update Score Student](#5-update-score-student)
* [Student](#student)
    1. [Get All Data Student](#1-get-all-data-student)
    1. [Insert New Student](#2-insert-new-student)
    1. [Update Student](#3-update-student)
    1. [Delete Student](#4-delete-student)
* [Subject](#subject)
    1. [Get All Subjct](#1-get-all-subjct)
    1. [Insert Subject](#2-insert-subject)
    1. [Delete Subject](#3-delete-subject)
    1. [Update Subject](#4-update-subject)
* [Teacher](#teacher)
    1. [Get All Teacher](#1-get-all-teacher)
    1. [New Teacher](#2-new-teacher)
    1. [Find Teacher By Name](#3-find-teacher-by-name)
    1. [Update Teacher](#4-update-teacher)
    1. [Delete Teacher](#5-delete-teacher)
* [YearSchool](#yearschool)
    1. [Get All School Year](#1-get-all-school-year)
    1. [New Year School](#2-new-year-school)
    1. [Get By Year](#3-get-by-year)
    1. [Update School Year](#4-update-school-year)

--------



## Materi



### 1. Get All Materi



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



### 2. Insert New Materi



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{base_url}}/materi/insert
```



***Body:***

```js        
{
    "title" : "perkenalan",
    "description" : "matematika adalah pelajaran yang dibutuhkan",
    "subjectId" : "A001"
}
```



### 3. New Request



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: {{base_url}}/materi/delete/2
```



### 4. Update Data Materi



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: {{base_url}}/materi/5
```



***Body:***

```js        
{
    "title" : "pertemuan ke 1"
}
```



## ClassRoom



### 1. Insert Room



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{base_url}}/roomclass/insert
```



***Body:***

```js        
{
    "className"     : "Kelas 1",
    "teacherName"   : "5"
}
```



### 2. Get All Data Room Class



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/roomclass/index
```



### 3. Delete Room



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: {{base_url}}/roomclass/delete/2
```



### 4. Update Room



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: {{base_url}}/roomclass/1
```



***Body:***

```js        
{
    "className" : "Kelas 1A"
}
```



### 5. FindRoomClassById



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/roomclass/index/1
```



## Score



### 1. Get All Score



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



### 2. Insert New Score



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{base_url}}/score/insert
```



***Body:***

```js        
{
    
    "value" : "85",
    "studentId" : "1",
    "yearsId"   : "3",
    "subjectId" : "A001"
}
```



### 3. Find Student Score



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/score/index/faisal
```



### 4. Find Score By Class And Subject



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/score/index/by
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| roomClass | Kelas 1B |  |
| subjectName | Matematika |  |



### 5. Update Score Student



***Endpoint:***

```bash
Method: PUT
Type: 
URL: {{base_url}}/score/
```



## Student



### 1. Get All Data Student



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/student/index
```



### 2. Insert New Student



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{base_url}}/student/insert
```



***Body:***

```js        
{
    "firstName" : "Deni",
    "lastName"  : "Maulana",
    "nik"       : "123123",
    "address"   : "Bandar Lampung",
    "RoomClass" : "1"
}
```



### 3. Update Student



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: {{base_url}}/student/update/2
```



***Body:***

```js        
{
    "firstName" : "Esmeralda"

}
```



### 4. Delete Student



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: {{base_url}}/student/delete/1
```



## Subject



### 1. Get All Subjct



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/subject/index
```



### 2. Insert Subject



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{base_url}}/subject/insert
```



***Body:***

```js        
{
    "id"            : "A001",
    "subjectName"   : "Matematika",
    "description"   : "tes",
    "teacherName"   : "5"
}
```



### 3. Delete Subject



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: {{base_url}}/subject/delete/A001
```



### 4. Update Subject



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: {{base_url}}/subject/update/A001
```



***Body:***

```js        
{
    
}
```



## Teacher



### 1. Get All Teacher



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



### 2. New Teacher



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{base_url}}/teacher/insert
```



***Body:***

```js        
{
    "nuptk" : "178012381231",
    "firstName"  : "Mustika",
    "lastName" : "Reza",
    "email"  : "murel@gmail.com",
    "address"    : "bandar lampung",
    "phone"     : "0908924342"
}
```



### 3. Find Teacher By Name



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



### 4. Update Teacher



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: {{base_url}}/teacher/update/2
```



***Body:***

```js        
{
   "lastName": ". S",
    "email": ":Seirin.fight232@gmail.com",
    "address": ":bandar Lampung",
    "phone": "0822282138584"
}
```



### 5. Delete Teacher



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: {{base_url}}/teacher/delete/4
```



## YearSchool



### 1. Get All School Year



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/year/index
```



### 2. New Year School



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{base_url}}/year/insert
```



***Body:***

```js        
{
    "schoolYear"    : "2023-03-09",
    "semester"      : "2"
}
```



### 3. Get By Year



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/year/index/year/2021-09-09
```



### 4. Update School Year



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: {{base_url}}/year/update
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| id | 4 |  |



***Body:***

```js        
{
    "year": "2022-03-09",
    "semester" : "2"
}
```



---
[Back to top](#elearning)

>
