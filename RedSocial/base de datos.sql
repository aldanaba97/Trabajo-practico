USE [RedSocial]
GO
/****** Object:  Table [dbo].[Administradores]    Script Date: 09/11/2020 17:43:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Administradores](
	[id_administrador] [int] IDENTITY(1,1) NOT NULL,
	[nombre_usuario] [nchar](30) NULL,
	[contrasena] [nchar](10) NULL,
	[email] [nchar](30) NOT NULL,
 CONSTRAINT [PK_Administradores] PRIMARY KEY CLUSTERED 
(
	[id_administrador] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Comentarios]    Script Date: 09/11/2020 17:43:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Comentarios](
	[id_comentario] [int] IDENTITY(1,1) NOT NULL,
	[descripcion] [nchar](150) NOT NULL,
	[valoracion] [int] NULL,
	[fecha] [date] NOT NULL,
	[id_comercio] [int] NULL,
	[nombreUsuario] [nchar](50) NULL,
 CONSTRAINT [PK_Comentarios] PRIMARY KEY CLUSTERED 
(
	[id_comentario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Comercios]    Script Date: 09/11/2020 17:43:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Comercios](
	[id_comercio] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nchar](50) NOT NULL,
	[direccion] [nchar](50) NULL,
	[telefono] [nchar](30) NOT NULL,
	[estado] [bit] NULL,
	[redSocial] [nchar](30) NULL,
	[Informacion] [nchar](100) NULL,
	[id_rubro] [int] NULL,
	[ruta] [varchar](100) NULL,
 CONSTRAINT [PK_Comercios] PRIMARY KEY CLUSTERED 
(
	[id_comercio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Ofertas]    Script Date: 09/11/2020 17:43:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Ofertas](
	[id_oferta] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nchar](30) NOT NULL,
	[precio] [float] NOT NULL,
	[estado] [bit] NULL,
	[fecha] [date] NULL,
	[id_comercio] [int] NULL,
	[descripcion] [nchar](110) NOT NULL,
	[cantidad] [int] NOT NULL,
	[ruta] [varchar](100) NULL,
 CONSTRAINT [PK_Ofertas] PRIMARY KEY CLUSTERED 
(
	[id_oferta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Respuestas]    Script Date: 09/11/2020 17:43:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Respuestas](
	[id_rta] [int] IDENTITY(1,1) NOT NULL,
	[descripcion] [nchar](150) NOT NULL,
	[fecha] [date] NULL,
	[id_comentario] [int] NULL,
 CONSTRAINT [PK_Respuestas] PRIMARY KEY CLUSTERED 
(
	[id_rta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[rubros]    Script Date: 09/11/2020 17:43:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[rubros](
	[id_rubro] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nchar](30) NOT NULL,
	[estado] [bit] NULL,
	[descripcion] [nchar](60) NULL,
	[ruta] [varchar](100) NULL,
 CONSTRAINT [PK_rubros] PRIMARY KEY CLUSTERED 
(
	[id_rubro] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[Comentarios]  WITH CHECK ADD  CONSTRAINT [FK_Comentarios_Comercios] FOREIGN KEY([id_comercio])
REFERENCES [dbo].[Comercios] ([id_comercio])
GO
ALTER TABLE [dbo].[Comentarios] CHECK CONSTRAINT [FK_Comentarios_Comercios]
GO
ALTER TABLE [dbo].[Comercios]  WITH CHECK ADD  CONSTRAINT [FK_Comercios_rubros] FOREIGN KEY([id_rubro])
REFERENCES [dbo].[rubros] ([id_rubro])
GO
ALTER TABLE [dbo].[Comercios] CHECK CONSTRAINT [FK_Comercios_rubros]
GO
ALTER TABLE [dbo].[Ofertas]  WITH CHECK ADD  CONSTRAINT [FK_Ofertas_Comercios] FOREIGN KEY([id_comercio])
REFERENCES [dbo].[Comercios] ([id_comercio])
GO
ALTER TABLE [dbo].[Ofertas] CHECK CONSTRAINT [FK_Ofertas_Comercios]
GO
ALTER TABLE [dbo].[Respuestas]  WITH CHECK ADD  CONSTRAINT [FK_Respuestas_Comentarios] FOREIGN KEY([id_comentario])
REFERENCES [dbo].[Comentarios] ([id_comentario])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Respuestas] CHECK CONSTRAINT [FK_Respuestas_Comentarios]
GO
