-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.5.62-log - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para helpdeskbd
DROP DATABASE IF EXISTS `helpdeskbd`;
CREATE DATABASE IF NOT EXISTS `helpdeskbd` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `helpdeskbd`;

-- Copiando estrutura para tabela helpdeskbd.chamados
DROP TABLE IF EXISTS `chamados`;
CREATE TABLE IF NOT EXISTS `chamados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `solicitante` varchar(45) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `descricao` varchar(3000) DEFAULT NULL,
  `data_abertura` date DEFAULT NULL,
  `data_alvo` date DEFAULT NULL,
  `clientes_id` int(11) NOT NULL,
  `tipos_atividades_id` int(11) NOT NULL,
  `usuarios_id` int(11) NOT NULL,
  `prioridadeChamado` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_chamados_clientes1_idx` (`clientes_id`),
  KEY `fk_chamados_tipos_atividades1_idx` (`tipos_atividades_id`),
  KEY `fk_chamados_usuarios1_idx` (`usuarios_id`),
  CONSTRAINT `fk_chamados_clientes1` FOREIGN KEY (`clientes_id`) REFERENCES `clientes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_chamados_tipos_atividades1` FOREIGN KEY (`tipos_atividades_id`) REFERENCES `tipos_atividades` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_chamados_usuarios1` FOREIGN KEY (`usuarios_id`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela helpdeskbd.clientes
DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_cliente` varchar(70) NOT NULL,
  `cpfOuCnpj` varchar(100) NOT NULL,
  PRIMARY KEY (`id`,`cpfOuCnpj`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela helpdeskbd.clientes_contato
DROP TABLE IF EXISTS `clientes_contato`;
CREATE TABLE IF NOT EXISTS `clientes_contato` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(75) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `celular` varchar(45) DEFAULT NULL,
  `clientes_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_clientes_contato_clientes1_idx` (`clientes_id`),
  CONSTRAINT `fk_clientes_contato_clientes1` FOREIGN KEY (`clientes_id`) REFERENCES `clientes` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela helpdeskbd.clientes_endereco
DROP TABLE IF EXISTS `clientes_endereco`;
CREATE TABLE IF NOT EXISTS `clientes_endereco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `endereco` varchar(120) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `clientes_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_clientes_endereco_clientes1_idx` (`clientes_id`),
  CONSTRAINT `fk_clientes_endereco_clientes1` FOREIGN KEY (`clientes_id`) REFERENCES `clientes` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='	';

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela helpdeskbd.config
DROP TABLE IF EXISTS `config`;
CREATE TABLE IF NOT EXISTS `config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_empresa` varchar(100) NOT NULL,
  `telefone_empresa` varchar(20) DEFAULT NULL,
  `email_empresa` varchar(100) DEFAULT NULL,
  `endereco_completo_empresa` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela helpdeskbd.grupo_acesso
DROP TABLE IF EXISTS `grupo_acesso`;
CREATE TABLE IF NOT EXISTS `grupo_acesso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_grupo` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela helpdeskbd.tipos_atividades
DROP TABLE IF EXISTS `tipos_atividades`;
CREATE TABLE IF NOT EXISTS `tipos_atividades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela helpdeskbd.usuarios
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_usuario` varchar(60) NOT NULL,
  `login_usuario` varchar(45) NOT NULL,
  `senha_usuario` varchar(45) DEFAULT NULL,
  `grupo_acesso_id` int(11) NOT NULL,
  `config_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`login_usuario`),
  KEY `fk_usuarios_grupo_acesso_idx` (`grupo_acesso_id`),
  KEY `fk_usuarios_config1_idx` (`config_id`),
  CONSTRAINT `fk_usuarios_config1` FOREIGN KEY (`config_id`) REFERENCES `config` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_grupo_acesso` FOREIGN KEY (`grupo_acesso_id`) REFERENCES `grupo_acesso` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
