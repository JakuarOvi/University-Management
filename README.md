# University Management System

The original Java Swing university management application. Its source code and
icons are in `src/university/management` and `src/icons`.

## Requirements

- JDK 23 or newer
- Apache Ant 1.10 or newer
- MySQL Server for database-backed features

## Build and run

From the repository root, build the desktop application with:

```bash
ant -f build.xml jar
```

Launch it with:

```bash
ant -f build.xml run
```

Ant downloads the desktop application's third-party libraries into the ignored
`lib/` directory on the first build. To run the database-backed features,
configure MySQL and create the `uniproject` database and expected tables.
