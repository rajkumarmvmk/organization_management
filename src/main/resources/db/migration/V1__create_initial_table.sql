-- organization_management.organization definition

CREATE TABLE `organization` (
  `id` varchar(255) NOT NULL,
  `company_type` enum('PRIVATE','PUBLIC','TRUST') DEFAULT NULL,
  `country` varchar(255) NOT NULL,
  `industry` varchar(255) NOT NULL,
  `organization_code` varchar(12) NOT NULL,
  `organization_name` varchar(50) NOT NULL,
  `status` enum('ACTIVE','INACTIVE') DEFAULT NULL,
  `timezone` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_63cjp5qm2nw5u9f0khcq7q8ue` (`organization_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- organization_management.sub_organization definition

CREATE TABLE `sub_organization` (
  `id` varchar(255) NOT NULL,
  `company_type` enum('PRIVATE','PUBLIC','TRUST') NOT NULL,
  `country` varchar(30) NOT NULL,
  `industry` varchar(30) NOT NULL,
  `status` enum('ACTIVE','INACTIVE') NOT NULL,
  `sub_organization_code` varchar(12) NOT NULL,
  `sub_organization_name` varchar(30) NOT NULL,
  `timezone` varchar(10) NOT NULL,
  `organization_entity_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfd73v7cphm3ld3fqolstntbab` (`organization_entity_id`),
  CONSTRAINT `FKfd73v7cphm3ld3fqolstntbab` FOREIGN KEY (`organization_entity_id`) REFERENCES `organization` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- organization_management.client definition

CREATE TABLE `client` (
  `id` varchar(255) NOT NULL,
  `client_code` varchar(12) NOT NULL,
  `client_name` varchar(30) NOT NULL,
  `company_type` enum('PRIVATE','PUBLIC','TRUST') NOT NULL,
  `country` varchar(30) NOT NULL,
  `industry` varchar(30) NOT NULL,
  `status` enum('ACTIVE','INACTIVE') NOT NULL,
  `timezone` varchar(30) NOT NULL,
  `organization_entity_id` varchar(255) DEFAULT NULL,
  `sub_organization_entity_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2eypryp9s78g6u2kqrxpmb7p7` (`organization_entity_id`),
  KEY `FK8bf7usteo8gusoeqar6gcr9ha` (`sub_organization_entity_id`),
  CONSTRAINT `FK2eypryp9s78g6u2kqrxpmb7p7` FOREIGN KEY (`organization_entity_id`) REFERENCES `organization` (`id`),
  CONSTRAINT `FK8bf7usteo8gusoeqar6gcr9ha` FOREIGN KEY (`sub_organization_entity_id`) REFERENCES `sub_organization` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- organization_management.employees definition

CREATE TABLE `employees` (
  `id` varchar(255) NOT NULL,
  `designation` varchar(30) NOT NULL,
  `employee_code` varchar(10) NOT NULL,
  `employee_name` varchar(30) NOT NULL,
  `organization_entity_id` varchar(255) DEFAULT NULL,
  `sub_organization_entity_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_etqhw9qqnad1kyjq3ks1glw8x` (`employee_code`),
  KEY `FK2wj9m6er3k8q85we9vkou2nww` (`organization_entity_id`),
  KEY `FKgv6y52n09kbxpbmo3p8d6hh46` (`sub_organization_entity_id`),
  CONSTRAINT `FK2wj9m6er3k8q85we9vkou2nww` FOREIGN KEY (`organization_entity_id`) REFERENCES `organization` (`id`),
  CONSTRAINT `FKgv6y52n09kbxpbmo3p8d6hh46` FOREIGN KEY (`sub_organization_entity_id`) REFERENCES `sub_organization` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- organization_management.projects definition

CREATE TABLE `projects` (
  `id` varchar(255) NOT NULL,
  `end_date` date NOT NULL,
  `project_code` varchar(10) NOT NULL,
  `project_title` varchar(30) NOT NULL,
  `start_date` date NOT NULL,
  `status` enum('ACTIVE','INACTIVE') DEFAULT NULL,
  `client_entity_id` varchar(255) DEFAULT NULL,
  `organization_entity_id` varchar(255) DEFAULT NULL,
  `sub_organization_entity_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKaxdjkgbhv17dqew6kgfiwyrga` (`client_entity_id`),
  KEY `FK5imvd69b3cokqj0qf5atmo3ra` (`organization_entity_id`),
  KEY `FKcscv3leba6mqk9c7dqt041v3a` (`sub_organization_entity_id`),
  CONSTRAINT `FK5imvd69b3cokqj0qf5atmo3ra` FOREIGN KEY (`organization_entity_id`) REFERENCES `organization` (`id`),
  CONSTRAINT `FKaxdjkgbhv17dqew6kgfiwyrga` FOREIGN KEY (`client_entity_id`) REFERENCES `client` (`id`),
  CONSTRAINT `FKcscv3leba6mqk9c7dqt041v3a` FOREIGN KEY (`sub_organization_entity_id`) REFERENCES `sub_organization` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- organization_management.`_user` definition

CREATE TABLE `_user` (
  `id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` enum('ADMIN','MANAGER','USER') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;