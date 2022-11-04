INSERT INTO TB_SENSOR_TYPE (sensor_type)
VALUES ('adm');
INSERT INTO TB_SENSOR_TYPE (sensor_type)
VALUES ('leitor');
INSERT INTO TB_SENSOR_TYPE (sensor_type)
VALUES ('criador');
INSERT INTO TB_SENSOR_TYPE (sensor_type)
VALUES ('doido');
INSERT INTO tb_place (place_name)
VALUES ('Sala 1');
INSERT INTO tb_place (place_name)
VALUES ('Sala 2');
INSERT INTO tb_place (place_name)
VALUES ('Sala 3');
INSERT INTO tb_sensor (
        sensor_name,
        description,
        latitude,
        longitude,
        sensor_type_id,
        place_id
    )
VALUES ('Sensor 1', 'Sensor 1', 0, 0, 1, 1);
INSERT INTO tb_sensor (
        sensor_name,
        description,
        latitude,
        longitude,
        sensor_type_id,
        place_id
    )
VALUES ('Sensor 2', 'Sensor 2', 0, 0, 2, 2);
INSERT INTO tb_sensor (
        sensor_name,
        description,
        latitude,
        longitude,
        sensor_type_id,
        place_id
    )
VALUES ('Sensor 3', 'Sensor 3', 0, 0, 3, 3);
INSERT INTO tb_user (user_name, password)
VALUES (
        'admin',
        -- 1234
        '$2a$10$uQx0Qwd9Y8MVUgtY6telb.mbMZ2koQTe4By70DLdFnXVrCvo9b/Ta'
    );
INSERT INTO tb_user (user_name, password)
VALUES (
        'Teonas',
        -- secreta
        '$2a$10$K5caYuqCudG1cpmXyjzoBuOXOMQsZgLnFPqBz62LrV4N3ALRhqX3a'
    );