create table Course
(
    courseId   int auto_increment
        primary key,
    courseName varchar(255) not null
);

create table Users
(
    id       varchar(50)  not null
        primary key,
    name     varchar(255) not null,
    email    varchar(255) not null,
    password varchar(255) not null,
    constraint email
        unique (email)
);

create table Student
(
    id        varchar(50) not null
        primary key,
    studentId varchar(50) not null,
    constraint studentId
        unique (studentId),
    constraint Student_ibfk_1
        foreign key (id) references Users (id)
            on delete cascade
);

create table Enrollment
(
    enrollmentId int auto_increment
        primary key,
    studentId    varchar(50) null,
    courseId     int         null,
    constraint Enrollment_ibfk_1
        foreign key (studentId) references Student (id)
            on delete cascade,
    constraint Enrollment_ibfk_2
        foreign key (courseId) references Course (courseId)
            on delete cascade
);

create index courseId
    on Enrollment (courseId);

create index studentId
    on Enrollment (studentId);

create table Teacher
(
    id        varchar(50) not null
        primary key,
    teacherId varchar(50) not null,
    constraint teacherId
        unique (teacherId),
    constraint Teacher_ibfk_1
        foreign key (id) references Users (id)
            on delete cascade
);