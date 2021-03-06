USE [master]
GO
/****** Object:  Database [MotorcycleManagement]    Script Date: 7/23/2021 11:15:18 AM ******/
CREATE DATABASE [MotorcycleManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'MortocycleManagement', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\MortocycleManagement.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'MortocycleManagement_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\MortocycleManagement_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [MotorcycleManagement] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [MotorcycleManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [MotorcycleManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [MotorcycleManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [MotorcycleManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET  DISABLE_BROKER 
GO
ALTER DATABASE [MotorcycleManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [MotorcycleManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [MotorcycleManagement] SET  MULTI_USER 
GO
ALTER DATABASE [MotorcycleManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [MotorcycleManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [MotorcycleManagement] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [MotorcycleManagement] SET DELAYED_DURABILITY = DISABLED 
GO
USE [MotorcycleManagement]
GO
/****** Object:  Table [dbo].[TblBike]    Script Date: 7/23/2021 11:15:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblBike](
	[motorcycleID] [varchar](10) NOT NULL,
	[model] [nvarchar](50) NULL,
	[year] [datetime] NULL,
	[condition] [varchar](50) NULL,
	[price] [float] NULL,
	[quantity] [int] NULL,
	[warranty] [nvarchar](50) NULL,
	[brandID] [varchar](10) NULL,
 CONSTRAINT [PK_TblBike] PRIMARY KEY CLUSTERED 
(
	[motorcycleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblBrand]    Script Date: 7/23/2021 11:15:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblBrand](
	[brandID] [varchar](10) NOT NULL,
	[brandName] [nvarchar](50) NOT NULL,
	[country] [nvarchar](50) NOT NULL,
	[description] [nvarchar](200) NOT NULL,
 CONSTRAINT [PK_TblBrand] PRIMARY KEY CLUSTERED 
(
	[brandID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblUser]    Script Date: 7/23/2021 11:15:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblUser](
	[userID] [varchar](10) NOT NULL,
	[fullName] [nvarchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[status] [bit] NOT NULL,
 CONSTRAINT [PK_TblUser] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[TblBike] ([motorcycleID], [model], [year], [condition], [price], [quantity], [warranty], [brandID]) VALUES (N'001', N'Yamaha Fazer FZ 25', CAST(N'2000-07-05 00:00:00.000' AS DateTime), N'Super', 70000, 3, N'No limit', N'001')
INSERT [dbo].[TblBike] ([motorcycleID], [model], [year], [condition], [price], [quantity], [warranty], [brandID]) VALUES (N'002', N'Yamaha Smax', CAST(N'2014-05-07 00:00:00.000' AS DateTime), N'Slow', 120000, 4, N'Limit', N'001')
INSERT [dbo].[TblBike] ([motorcycleID], [model], [year], [condition], [price], [quantity], [warranty], [brandID]) VALUES (N'003', N'Kawasaki D-Tracker 150', CAST(N'2019-05-05 00:00:00.000' AS DateTime), N'Super', 230000, 8, N'No litmit', N'002')
INSERT [dbo].[TblBike] ([motorcycleID], [model], [year], [condition], [price], [quantity], [warranty], [brandID]) VALUES (N'004', N'Ducati 748 RS', CAST(N'2006-12-09 00:00:00.000' AS DateTime), N'Super', 200000, 7, N'No limit', N'003')
INSERT [dbo].[TblBike] ([motorcycleID], [model], [year], [condition], [price], [quantity], [warranty], [brandID]) VALUES (N'007', N'BMW i8', CAST(N'2018-07-14 00:00:00.000' AS DateTime), N'Super Car', 43000, 5, N'Limit', N'007')
INSERT [dbo].[TblBike] ([motorcycleID], [model], [year], [condition], [price], [quantity], [warranty], [brandID]) VALUES (N'008', N'Wave RSX', CAST(N'2019-04-12 00:00:00.000' AS DateTime), N'Slow', 94030, 5, N'Limit', N'001')
INSERT [dbo].[TblBike] ([motorcycleID], [model], [year], [condition], [price], [quantity], [warranty], [brandID]) VALUES (N'009', N'Honda C7', CAST(N'2005-05-06 00:00:00.000' AS DateTime), N'Slow', 40000, 6, N'Limit', N'005')
INSERT [dbo].[TblBike] ([motorcycleID], [model], [year], [condition], [price], [quantity], [warranty], [brandID]) VALUES (N'010', N'Yante', CAST(N'2020-06-04 00:00:00.000' AS DateTime), N'Super', 57000, 5, N'Limit', N'007')
INSERT [dbo].[TblBrand] ([brandID], [brandName], [country], [description]) VALUES (N'001', N'Yamaha', N'Japanese', N'Stronger, Faster')
INSERT [dbo].[TblBrand] ([brandID], [brandName], [country], [description]) VALUES (N'002', N'Kawasaki', N'America', N'Beautiful, Stroger, Faster')
INSERT [dbo].[TblBrand] ([brandID], [brandName], [country], [description]) VALUES (N'003', N'Ducati', N'United State', N'Stronger, Faster')
INSERT [dbo].[TblBrand] ([brandID], [brandName], [country], [description]) VALUES (N'004', N'Honda4', N'Japanese', N'Greate')
INSERT [dbo].[TblBrand] ([brandID], [brandName], [country], [description]) VALUES (N'005', N'CupT', N'Vietnamese', N'Wonderful')
INSERT [dbo].[TblBrand] ([brandID], [brandName], [country], [description]) VALUES (N'007', N'BMW', N'France', N'Super')
INSERT [dbo].[TblUser] ([userID], [fullName], [password], [status]) VALUES (N'loi1', N'Quach Dai Loi', N'loi123', 0)
INSERT [dbo].[TblUser] ([userID], [fullName], [password], [status]) VALUES (N'long', N'Bui Viet Long', N'long123', 1)
INSERT [dbo].[TblUser] ([userID], [fullName], [password], [status]) VALUES (N'qhai', N'Nguyen Quang Hai', N'hai123', 0)
ALTER TABLE [dbo].[TblBike]  WITH CHECK ADD  CONSTRAINT [FK_TblBike_TblBrand] FOREIGN KEY([brandID])
REFERENCES [dbo].[TblBrand] ([brandID])
GO
ALTER TABLE [dbo].[TblBike] CHECK CONSTRAINT [FK_TblBike_TblBrand]
GO
USE [master]
GO
ALTER DATABASE [MotorcycleManagement] SET  READ_WRITE 
GO
