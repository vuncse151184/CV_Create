use master
go
--drop database StudentCV
--go
create database StudentCV
go
use StudentCV
go
create table Student(
	StudentId int identity(1,1) PRIMARY KEY,
	JobPosition nvarchar(100) null,
	EduQua nvarchar(100) null,
	Experience nvarchar(100) null,
	StuName nvarchar(100) null,
	PhoneNum nvarchar(10) null,
	Addr nvarchar(255) null,
	Email nvarchar(255) not null,
	Status bit DEFAULT '1'
)
go
create table Major(
	MajorId nvarchar(50) Primary key,
	MajorName nvarchar(255),
	Status bit DEFAULT '1'
)
go
create table Stu_Major(
	StudentId int foreign key references Student(StudentId),
	MajorId nvarchar(50) foreign key references Major(MajorId),
	PRIMARY KEY(StudentId,MajorId),
	Status bit DEFAULT '1'
)
go
create table Skill(
	SkillId nvarchar(50) PRIMARY KEY,
	SkillName nvarchar(50) null,
	SkillType nvarchar(50) null,
	Status bit DEFAULT '1'
)
go
create table Stu_Skill(
	StudentId int foreign key references Student(StudentId),
	SkillId nvarchar(50) foreign key references Skill(SkillId),
	PRIMARY KEY(StudentId,SkillId),
	Status bit DEFAULT '1'
)
go
create table Company(
	CompanyId nvarchar(50) PRIMARY KEY,
	CompanyName nvarchar(100),
	Specialization nvarchar(250),
	Email nvarchar(50),
	PhoneNumber int,
	Addr nvarchar(250),
	Status bit DEFAULT '1'
)
go
create table Job(
	JobId int identity(1,1) PRIMARY KEY,
	CompanyId nvarchar(50) foreign key references Company(CompanyId),
	JobReq ntext,
	JobName nvarchar(50),
	Salary float,
	JobType nvarchar(50),
	JobLocation nvarchar(255),
	JobExperience int,
	JobPostDate Date,
	JobDescription ntext,
	Status bit DEFAULT '1'
)
go
create table Stu_Job(
	StudentId int foreign key references Student(StudentId),
	JobId int foreign key references Job(JobId),
	PRIMARY KEY(StudentId,JobId),
	Status bit DEFAULT '1'
)
go
create table CV(
	CvId int identity(1,1) PRIMARY KEY,
	StudentId int FOREIGN KEY REFERENCES Student(StudentId),
	Status bit DEFAULT '1'
)
go
create table CV_company(
	CvId int FOREIGN KEY REFERENCES CV(CvId),
	CompanyId nvarchar(50) FOREIGN KEY REFERENCES Company(CompanyId),
	PRIMARY KEY(CvId,CompanyId),
	Status bit DEFAULT '1'
)
go
create table Career(
	CareerId int identity(1,1) PRIMARY KEY,
	CareerName nvarchar(250),
	Status bit DEFAULT '1'
)
go
create table Company_career(
	CareerId int FOREIGN KEY REFERENCES Career(CareerId),
	CompanyId nvarchar(50) FOREIGN KEY REFERENCES Company(CompanyId),
	PRIMARY KEY(CareerId,CompanyId),
	Status bit DEFAULT '1'
)
go