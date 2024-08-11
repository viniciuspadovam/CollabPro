CREATE TABLE IF NOT EXISTS projects (
	id TEXT PRIMARY KEY UNIQUE NOT NULL,
	name TEXT NOT NULL,
	description TEXT NOT NULL,
	status TEXT NOT NULL,
	begin_date TIMESTAMP NOT NULL,
	end_date TIMESTAMP NOT NULL,
	conclusion_time INTEGER NOT NULL,
	worked_time INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS tasks (
	id TEXT PRIMARY KEY UNIQUE NOT NULL,
	name TEXT NOT NULL,
	description TEXT NOT NULL,
	conclusion_time INTEGER NOT NULL,
	worked_time INTEGER NOT NULL,
	priority TEXT NOT NULL,
	status TEXT NOT NULL,
	designed_worker TEXT NOT NULL,
	project_id TEXT NOT NULL REFERENCES projects(id)
);
