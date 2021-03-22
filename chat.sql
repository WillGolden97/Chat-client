-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 12-Mar-2021 às 00:16
-- Versão do servidor: 10.4.17-MariaDB
-- versão do PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `chat`
--

DELIMITER $$
--
-- Procedimentos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `Contatos` (IN `userNickName` VARCHAR(20))  NO SQL
select (SELECT clientes.nickName FROM clientes WHERE clientes.nickName = IF(Messages.MsgTo = userNickName, Messages.MsgFrom,Messages.MsgTo)) as nickNameContato, (SELECT clientes.nomeCliente FROM clientes WHERE clientes.nickName = IF(Messages.MsgTo = userNickName, Messages.MsgFrom,Messages.MsgTo)) as Contato, Messages.Messages, messages.Date FROM messages INNER JOIN clientes on messages.MsgFrom = clientes.nickName OR messages.MsgTo = clientes.nickName WHERE Messages.MsgTo = userNickName OR Messages.MsgFrom = userNickName GROUP by Contato ORDER BY messages.Date DESC$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `nomeCliente` varchar(20) NOT NULL,
  `nickName` varchar(20) NOT NULL,
  `senha` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`nomeCliente`, `nickName`, `senha`) VALUES
('Alyssom', 'ally77', 'a51696a86ebadde170b7b06e83f1ec82'),
('Marlon', 'marlon77', 'cefdad4bd12e8c57cdf9cf1d176b429a'),
('Rafael', 'rafa77', 'cbcc887b198ad392cd9f60027f27e37a'),
('William D.', 'willGolden', '69013773d31191dcc17bf195f73ef2e6');

-- --------------------------------------------------------

--
-- Estrutura da tabela `messages`
--

CREATE TABLE `messages` (
  `Idmessage` int(11) NOT NULL,
  `Messages` varchar(500) NOT NULL,
  `MsgFrom` varchar(20) NOT NULL,
  `MsgTo` varchar(20) NOT NULL,
  `Date` varchar(20) NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `messages`
--

INSERT INTO `messages` (`Idmessage`, `Messages`, `MsgFrom`, `MsgTo`, `Date`) VALUES
(9, 'E ai bl? Cara', 'ally77', 'willGolden', '2021-03-06 22:48:24'),
(10, 'Blz sim', 'willGolden', 'ally77', '2021-03-06 22:48:24'),
(11, 'E ai blz cara?', 'marlon77', 'willGolden', '2021-03-07 22:48:24'),
(12, 'blz sim mano ', 'willGolden', 'marlon77', '2021-03-07 22:48:24'),
(13, 'E ai mano, blz?', 'rafa77', 'willGolden', '2021-03-08 22:48:24'),
(14, 'Blz sim', 'willGolden', 'rafa77', '2021-03-08 22:48:24'),
(15, 'Maravilha então', 'rafa77', 'willGolden', '2021-03-09 22:48:24'),
(16, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'rafa77', 'willGolden', '2021-03-10 18:27:19'),
(19, 'E ai Rafa. Blz?', 'willGolden', 'rafa77', '2021-03-10 21:09:34'),
(20, 'E ai Will. Blz? ', 'rafa77', 'willGolden', '2021-03-10 21:10:05'),
(21, 'E ai Will. Blz? ', 'rafa77', 'willGolden', '2021-03-10 21:10:10'),
(22, 'E ai Marlon. Blz? ', 'willGolden', 'marlon77', '2021-03-10 21:16:14'),
(23, 'E ai Marlon. Blz? ', 'willGolden', 'marlon77', '2021-03-10 21:16:17'),
(24, 'E ai Marlon? ', 'willGolden', 'marlon77', '2021-03-10 21:16:40'),
(25, 'E ai Ally. Blz? ', 'willGolden', 'ally77', '2021-03-10 21:20:09'),
(26, 'E ai Will. Blz?', 'ally77', 'willGolden', '2021-03-10 21:27:36'),
(27, 'blz mano', 'willGolden', 'ally77', '2021-03-10 21:40:20'),
(28, 'maravilha entao ', 'ally77', 'willGolden', '2021-03-10 21:40:29'),
(29, 'E ai ', 'willGolden', 'ally77', '2021-03-10 21:42:18'),
(30, 'To bem mano. E vc?', 'marlon77', 'willGolden', '2021-03-11 02:58:31'),
(31, 'To tranquilo', 'willGolden', 'marlon77', '2021-03-11 02:58:43'),
(32, 'Que ótimo então', 'marlon77', 'willGolden', '2021-03-11 02:59:05'),
(33, 'Ainda bem ', 'marlon77', 'willGolden', '2021-03-11 03:00:58'),
(34, 'E vc como está?', 'willGolden', 'marlon77', '2021-03-11 03:10:43'),
(35, 'To bem ', 'marlon77', 'willGolden', '2021-03-11 03:10:52'),
(36, 'Ok então', 'marlon77', 'willGolden', '2021-03-11 03:11:07'),
(37, 'Tranquilo', 'willGolden', 'rafa77', '2021-03-11 04:15:42'),
(38, 'Tranquilo mano? ', 'willGolden', 'ally77', '2021-03-11 11:39:06'),
(39, 'blz mano', 'ally77', 'willGolden', '2021-03-11 18:28:45'),
(40, 'Como vc tá?', 'ally77', 'willGolden', '2021-03-11 18:28:47'),
(41, 'Traquilo', 'willGolden', 'ally77', '2021-03-11 18:29:47'),
(42, 'g fd', 'ally77', 'willGolden', '2021-03-11 18:34:22');

-- --------------------------------------------------------

--
-- Estrutura da tabela `sessao`
--

CREATE TABLE `sessao` (
  `clienteId` int(11) NOT NULL,
  `token` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`nickName`);

--
-- Índices para tabela `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`Idmessage`) USING BTREE,
  ADD KEY `msgToCliente` (`MsgTo`),
  ADD KEY `msgFromCliente` (`MsgFrom`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `messages`
--
ALTER TABLE `messages`
  MODIFY `Idmessage` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `messages`
--
ALTER TABLE `messages`
  ADD CONSTRAINT `msgFromCliente` FOREIGN KEY (`MsgFrom`) REFERENCES `clientes` (`nickName`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `msgToCliente` FOREIGN KEY (`MsgTo`) REFERENCES `clientes` (`nickName`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
