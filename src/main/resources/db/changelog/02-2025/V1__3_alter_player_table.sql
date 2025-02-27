alter table player drop column if exists team;
update player set team_id='7a609f88-a159-4d1e-b831-9c1f8b512ed8'::uuid where team_id is null;