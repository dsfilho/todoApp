
CREATE DATABASE IF NOT EXISTS todoApp DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE todoApp;

CREATE TABLE projects (
  id int(11) NOT NULL,
  name varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  description varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  createdAt datetime NOT NULL,
  UpdatedAt datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE tasks (
  id int(11) NOT NULL,
  idProject int(11) NOT NULL,
  name varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  description varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  completed tinyint(1) NOT NULL,
  notes varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  deadline date NOT NULL,
  createdAt datetime NOT NULL,
  updatedAt datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


ALTER TABLE projects
  ADD PRIMARY KEY (id);

ALTER TABLE tasks
  ADD PRIMARY KEY (id),
  ADD KEY fk_projects (idProject);


ALTER TABLE projects
  MODIFY id int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE tasks
  MODIFY id int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE tasks
  ADD CONSTRAINT fk_projects FOREIGN KEY (idProject) REFERENCES projects (id) ON DELETE CASCADE ON UPDATE CASCADE;
