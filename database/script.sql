USE [Imageram]
GO
/****** Object:  Table [dbo].[Photos]    Script Date: 03/24/2022 15:14:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Photos](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[album_id] [varchar](50) NULL,
	[user_id] [varchar](50) NOT NULL,
	[title] [nvarchar](120) NULL,
	[description] [nvarchar](255) NULL,
	[privacy] [varchar](20) NOT NULL,
	[upload_date] [datetime] NOT NULL,
	[view] [int] NULL,
	[like] [int] NULL,
	[image_path] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Photos] ON
INSERT [dbo].[Photos] ([id], [album_id], [user_id], [title], [description], [privacy], [upload_date], [view], [like], [image_path]) VALUES (1, N'', N'sannxt', N'beautiful flowers', N'', N'', CAST(0x0000AE59017CB543 AS DateTime), 65, NULL, N'images\cherry-blossom_VQ2YAXD9PD.jpg')
INSERT [dbo].[Photos] ([id], [album_id], [user_id], [title], [description], [privacy], [upload_date], [view], [like], [image_path]) VALUES (6, N'', N'sannxt', N'', N'', N'', CAST(0x0000AE3D0184C5F0 AS DateTime), 18, NULL, N'images\lovro-pavlicic-AHLz7x6SwGs-unsplash.jpg')
INSERT [dbo].[Photos] ([id], [album_id], [user_id], [title], [description], [privacy], [upload_date], [view], [like], [image_path]) VALUES (8, N'', N'sannxt', N'', N'', N'', CAST(0x0000AE5A00135A1A AS DateTime), 4, NULL, N'images\photo-1647249696855-a59fb79ed943.avif')
INSERT [dbo].[Photos] ([id], [album_id], [user_id], [title], [description], [privacy], [upload_date], [view], [like], [image_path]) VALUES (9, N'', N'sannxt', N'', N'', N'', CAST(0x0000AE5A00135F1C AS DateTime), 5, NULL, N'images\photo-1554261197-de743c7e0ad3.avif')
INSERT [dbo].[Photos] ([id], [album_id], [user_id], [title], [description], [privacy], [upload_date], [view], [like], [image_path]) VALUES (10, N'', N'sannxt', N'', N'', N'', CAST(0x0000AE1F00138F18 AS DateTime), 2, NULL, N'images\photo-1646734006406-3a34c55cc088.avif')
INSERT [dbo].[Photos] ([id], [album_id], [user_id], [title], [description], [privacy], [upload_date], [view], [like], [image_path]) VALUES (11, N'', N'sannxt', N'', N'', N'', CAST(0x0000AE5A00139299 AS DateTime), 3, NULL, N'images\photo-1647059304131-4eb55e198a89.avif')
INSERT [dbo].[Photos] ([id], [album_id], [user_id], [title], [description], [privacy], [upload_date], [view], [like], [image_path]) VALUES (12, N'', N'yasuo', N'', N'', N'', CAST(0x0000AD490014645C AS DateTime), 2, NULL, N'images\photo-1624791980387-62548d622c57.avif')
INSERT [dbo].[Photos] ([id], [album_id], [user_id], [title], [description], [privacy], [upload_date], [view], [like], [image_path]) VALUES (13, N'', N'yasuo', N'', N'', N'', CAST(0x0000AD490014675D AS DateTime), 10, NULL, N'images\photo-1647203496091-479bcab4df1f.avif')
INSERT [dbo].[Photos] ([id], [album_id], [user_id], [title], [description], [privacy], [upload_date], [view], [like], [image_path]) VALUES (14, N'', N'yasuo', N'', N'', N'', CAST(0x0000AE5A0014A528 AS DateTime), 1, NULL, N'images\mehrab-zahedbeigi-K6uxTJPecNY-unsplash.jpg')
INSERT [dbo].[Photos] ([id], [album_id], [user_id], [title], [description], [privacy], [upload_date], [view], [like], [image_path]) VALUES (15, N'', N'luysyn', N'', N'', N'', CAST(0x0000AE5A00E2D4C0 AS DateTime), 3, NULL, N'images\svitlana-lq3PESIaK7s-unsplash.jpg')
INSERT [dbo].[Photos] ([id], [album_id], [user_id], [title], [description], [privacy], [upload_date], [view], [like], [image_path]) VALUES (16, N'', N'luysyn', N'', N'', N'', CAST(0x0000AE5A00E2D862 AS DateTime), 1, NULL, N'images\uby-yanes-X3GqOzEklYI-unsplash.jpg')
INSERT [dbo].[Photos] ([id], [album_id], [user_id], [title], [description], [privacy], [upload_date], [view], [like], [image_path]) VALUES (17, N'', N'siget', N'', N'', N'', CAST(0x0000AE5A00E739D5 AS DateTime), 75, NULL, N'images\gustavo-zambelli-2b8pEYg2QX4-unsplash.jpg')
INSERT [dbo].[Photos] ([id], [album_id], [user_id], [title], [description], [privacy], [upload_date], [view], [like], [image_path]) VALUES (18, N'', N'siget', N'', N'', N'', CAST(0x0000AE5A00E7DF95 AS DateTime), 3, NULL, N'images\marco-biondi-0apwACX-W2Y-unsplash.jpg')
INSERT [dbo].[Photos] ([id], [album_id], [user_id], [title], [description], [privacy], [upload_date], [view], [like], [image_path]) VALUES (19, N'', N'siget', N'', N'', N'', CAST(0x0000AE5A00E7E30B AS DateTime), 1, NULL, N'images\jeremy-hynes-mpbwOtvS8Zc-unsplash.jpg')
INSERT [dbo].[Photos] ([id], [album_id], [user_id], [title], [description], [privacy], [upload_date], [view], [like], [image_path]) VALUES (20, N'', N'siget', N'', N'', N'', CAST(0x0000AE5A00E809E1 AS DateTime), 1, NULL, N'images\nail-gilfanov-nqWi9UtUN5I-unsplash.jpg')
INSERT [dbo].[Photos] ([id], [album_id], [user_id], [title], [description], [privacy], [upload_date], [view], [like], [image_path]) VALUES (21, N'', N'siget', N'', N'', N'', CAST(0x0000AE5A00E81086 AS DateTime), 1, NULL, N'images\jeremy-hynes-nHG_sF_k0w0-unsplash.jpg')
INSERT [dbo].[Photos] ([id], [album_id], [user_id], [title], [description], [privacy], [upload_date], [view], [like], [image_path]) VALUES (22, N'', N'abyyanes', N'', N'', N'', CAST(0x0000AE5A00E8BACB AS DateTime), 16, NULL, N'images\david-scanlon-YDXbXMJ5UGM-unsplash.jpg')
INSERT [dbo].[Photos] ([id], [album_id], [user_id], [title], [description], [privacy], [upload_date], [view], [like], [image_path]) VALUES (23, N'', N'abyyanes', N'', N'', N'', CAST(0x0000AE5A00E8BE3F AS DateTime), 1, NULL, N'images\annie-spratt-GkJ9hqqvcV8-unsplash.jpg')
INSERT [dbo].[Photos] ([id], [album_id], [user_id], [title], [description], [privacy], [upload_date], [view], [like], [image_path]) VALUES (24, N'', N'abyyanes', N'', N'', N'', CAST(0x0000AE5A00E8DACD AS DateTime), 2, NULL, N'images\zoo_monkey-Isne1TFoI78-unsplash.jpg')
INSERT [dbo].[Photos] ([id], [album_id], [user_id], [title], [description], [privacy], [upload_date], [view], [like], [image_path]) VALUES (25, N'', N'nasuts', N'', N'', N'', CAST(0x0000AE5B00F20E9C AS DateTime), 8, NULL, N'images\joe-straker-AaKSc_10TzY-unsplash.jpg')
INSERT [dbo].[Photos] ([id], [album_id], [user_id], [title], [description], [privacy], [upload_date], [view], [like], [image_path]) VALUES (26, N'', N'nasuts', N'', N'', N'', CAST(0x0000AE5B00F211FB AS DateTime), 1, NULL, N'images\jan-kopriva-IZ7W626JoQs-unsplash.jpg')
INSERT [dbo].[Photos] ([id], [album_id], [user_id], [title], [description], [privacy], [upload_date], [view], [like], [image_path]) VALUES (27, N'', N'nasuts', N'', N'', N'', CAST(0x0000AE5B00F22D7A AS DateTime), 1, NULL, N'images\julie-marsh-1LCogGiczlY-unsplash.jpg')
SET IDENTITY_INSERT [dbo].[Photos] OFF
/****** Object:  Table [dbo].[PageView]    Script Date: 03/24/2022 15:14:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PageView](
	[view] [int] NULL
) ON [PRIMARY]
GO
INSERT [dbo].[PageView] ([view]) VALUES (27)
/****** Object:  Table [dbo].[Followers]    Script Date: 03/24/2022 15:14:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Followers](
	[id] [varchar](50) NOT NULL,
	[folower_id] [varchar](50) NOT NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Followers] ([id], [folower_id]) VALUES (N'siget', N'sannxt')
INSERT [dbo].[Followers] ([id], [folower_id]) VALUES (N'nasuts', N'sannxt')
/****** Object:  Table [dbo].[Comments]    Script Date: 03/24/2022 15:14:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Comments](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NULL,
	[content] [nvarchar](max) NULL,
	[upload_time] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Albums]    Script Date: 03/24/2022 15:14:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Albums](
	[id] [varchar](50) NOT NULL,
	[title] [nvarchar](120) NULL,
	[description] [nvarchar](255) NULL,
	[view] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 03/24/2022 15:14:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Admin](
	[id] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Admin] ([id], [password]) VALUES (N'admin', N'admin')
/****** Object:  Table [dbo].[Users]    Script Date: 03/24/2022 15:14:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Users](
	[id] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[name] [nvarchar](255) NULL,
	[phone] [varchar](20) NULL,
	[email] [varchar](200) NULL,
	[address] [nvarchar](255) NULL,
	[avatar] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Users] ([id], [password], [name], [phone], [email], [address], [avatar]) VALUES (N'abyyanes', N'1', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Users] ([id], [password], [name], [phone], [email], [address], [avatar]) VALUES (N'ggg', N'123', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Users] ([id], [password], [name], [phone], [email], [address], [avatar]) VALUES (N'hello', N'123', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Users] ([id], [password], [name], [phone], [email], [address], [avatar]) VALUES (N'luysyn', N'1', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Users] ([id], [password], [name], [phone], [email], [address], [avatar]) VALUES (N'nasuts', N'1', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Users] ([id], [password], [name], [phone], [email], [address], [avatar]) VALUES (N'sannxt', N'12345', N'san', NULL, NULL, NULL, N'avatars\jan-kopriva-IZ7W626JoQs-unsplash.jpg')
INSERT [dbo].[Users] ([id], [password], [name], [phone], [email], [address], [avatar]) VALUES (N'siget', N'1', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Users] ([id], [password], [name], [phone], [email], [address], [avatar]) VALUES (N'yays', N'1', NULL, NULL, NULL, NULL, NULL)
/****** Object:  Table [dbo].[Test]    Script Date: 03/24/2022 15:14:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Test](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[image] [image] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tags]    Script Date: 03/24/2022 15:14:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tags](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](120) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Tags] ON
INSERT [dbo].[Tags] ([id], [title]) VALUES (1, N'Landscape')
INSERT [dbo].[Tags] ([id], [title]) VALUES (2, N'Wildlife')
INSERT [dbo].[Tags] ([id], [title]) VALUES (3, N'Macro')
INSERT [dbo].[Tags] ([id], [title]) VALUES (4, N'Underwater')
INSERT [dbo].[Tags] ([id], [title]) VALUES (5, N'Astrophotography')
INSERT [dbo].[Tags] ([id], [title]) VALUES (6, N'Aerial Photography')
INSERT [dbo].[Tags] ([id], [title]) VALUES (7, N'Scientific')
INSERT [dbo].[Tags] ([id], [title]) VALUES (8, N'Portraits')
INSERT [dbo].[Tags] ([id], [title]) VALUES (9, N'Weddings')
INSERT [dbo].[Tags] ([id], [title]) VALUES (10, N'Documentary')
INSERT [dbo].[Tags] ([id], [title]) VALUES (11, N'Sports')
INSERT [dbo].[Tags] ([id], [title]) VALUES (13, N'Lifestyle')
INSERT [dbo].[Tags] ([id], [title]) VALUES (14, N'Food')
INSERT [dbo].[Tags] ([id], [title]) VALUES (15, N'Home')
INSERT [dbo].[Tags] ([id], [title]) VALUES (16, N'Travel')
INSERT [dbo].[Tags] ([id], [title]) VALUES (17, N'Astronomy')
INSERT [dbo].[Tags] ([id], [title]) VALUES (18, N'Nature')
INSERT [dbo].[Tags] ([id], [title]) VALUES (19, N'Cooking')
INSERT [dbo].[Tags] ([id], [title]) VALUES (20, N'Fashion')
INSERT [dbo].[Tags] ([id], [title]) VALUES (21, N'Wellness')
INSERT [dbo].[Tags] ([id], [title]) VALUES (22, N'Dieting')
INSERT [dbo].[Tags] ([id], [title]) VALUES (23, N'Animals')
SET IDENTITY_INSERT [dbo].[Tags] OFF
/****** Object:  Table [dbo].[Tag_Photo]    Script Date: 03/24/2022 15:14:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tag_Photo](
	[tag_id] [int] NOT NULL,
	[photo_id] [int] NOT NULL
) ON [PRIMARY]
GO
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (18, 9)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (18, 11)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (18, 8)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (20, 13)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (20, 14)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (18, 6)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (14, 15)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (14, 16)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (23, 17)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (23, 18)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (18, 23)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (18, 24)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (1, 1)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (18, 1)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (18, 25)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (23, 25)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (23, 26)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (23, 27)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (18, 10)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (18, 22)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (23, 22)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (23, 19)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (23, 20)
INSERT [dbo].[Tag_Photo] ([tag_id], [photo_id]) VALUES (23, 21)
/****** Object:  ForeignKey [FK_TagToPhoto]    Script Date: 03/24/2022 15:14:33 ******/
ALTER TABLE [dbo].[Tag_Photo]  WITH CHECK ADD  CONSTRAINT [FK_TagToPhoto] FOREIGN KEY([photo_id])
REFERENCES [dbo].[Photos] ([id])
GO
ALTER TABLE [dbo].[Tag_Photo] CHECK CONSTRAINT [FK_TagToPhoto]
GO
/****** Object:  ForeignKey [FK_TPTag]    Script Date: 03/24/2022 15:14:33 ******/
ALTER TABLE [dbo].[Tag_Photo]  WITH CHECK ADD  CONSTRAINT [FK_TPTag] FOREIGN KEY([tag_id])
REFERENCES [dbo].[Tags] ([id])
GO
ALTER TABLE [dbo].[Tag_Photo] CHECK CONSTRAINT [FK_TPTag]
GO
