-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 21 mars 2024 à 16:11
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `database`
--

-- --------------------------------------------------------

--
-- Structure de la table `materiel`
--

CREATE TABLE `materiel` (
  `id` int(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `quantite` int(255) NOT NULL,
  `categorie` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `materiel`
--

INSERT INTO `materiel` (`id`, `nom`, `quantite`, `categorie`) VALUES
(1, 'ordinateur', 25, 'tabarka'),
(2, 'imprimente', 2, 'Informatique'),
(4, 'liste', 25, 'informatique');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `nom`, `prenom`, `email`) VALUES
(1, 'MAHER', 'SELMI', 'selmimaher42@gmail.com'),
(2, 'ahmed', 'selmi', 'ahmed selmi@gmail.com'),
(4, 'rami ', 'ahmadi', 'sss@gmail.com'),
(18, 'gjgiu', 'hgkuo', 'uiçopk@gkoi'),
(19, 'bhhh', 'vgg', 'iyiuyi@jhgj'),
(20, 'bhhh', 'vgg', 'iyiuyi@jhgj'),
(21, 'bhhh', 'vgg', 'iyiuyi@jhgj'),
(22, 'bhhh', 'vgg', 'iyiuyi@jhgj'),
(23, 'fdbdfb', 'fbfbfsv', 'fgsrfg'),
(24, 'dsc', 'dcsdcdcs', 'dcdsc@dcsd'),
(25, 'dsc', 'dcsdcdcs', 'dcdsc@dcsd'),
(26, 'sdv', 'vddsvvd', 'fsvfsv'),
(27, 'rfrvfv', 'fvdf', 'fbfdb@bfb'),
(28, '', 'fdgdg', ''),
(29, 'dzqqfd', 'dsqqs', 'sdsff@dfdgdfsg'),
(30, 'maher', 'seeelmi', 'selmimaher@gmail.come');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `materiel`
--
ALTER TABLE `materiel`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `materiel`
--
ALTER TABLE `materiel`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
