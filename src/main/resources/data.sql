INSERT INTO consumption(total_carbon_emitted,id,name) VALUES (1.1,1,'justtest');

INSERT INTO consumption(id,name) VALUES (0,'justtest');
INSERT INTO consumption_item (name,id, consumption_id, carbon_footprint, quatity) VALUES ('Machine a laver',1, 1, 150.0, 3), ('Ordinateur bureau',2, 1, 160, 3), ('Vehicule porche',3, 1,1500,1), ('Mixeur',4, 1, 30, 3);

INSERT INTO machine (id, default_footprint, img, name, usage, power, dtype) VALUES
(1, 600, 'https://i.ibb.co/xhzWFBM/fridge.png', 'Refrigerator', 'HOME_APPLIANCES', 150, 'Device'),
(2, 400, 'https://i.ibb.co/rb92mRx/laundry-machine.png', 'Laundry Machine', 'HOME_APPLIANCES', 500, 'Device'),
(3, 300, 'https://i.ibb.co/ThfhJFJ/microwave.png', 'Microwave', 'HOME_APPLIANCES', 1200, 'Device'),
(4, 250, 'https://i.ibb.co/ct6rTQ5/desktop-computer.png', 'Desktop Computer', 'IT', 450, 'Device'),
(5, 100, 'https://i.ibb.co/hLJJy8n/laptop.png', 'Laptop', 'IT', 60, 'Device'),
(6, 50, 'https://i.ibb.co/nM3G940/smartphone.png', 'Smartphone', 'IT', 5, 'Device'),
(7, 500, 'https://i.ibb.co/yPw9LCT/servers.png', 'Server', 'ENTERPRISE_INFRASTRUCTURE', 200, 'Device'),
(8, 15000, 'https://i.ibb.co/G97HP1x/data-center.png', 'Data Center', 'ENTERPRISE_INFRASTRUCTURE', 5000, 'Device'),
(9, 2000, 'https://i.ibb.co/8NN7kR0/hvac.png', 'HVAC System', 'ENTERPRISE_INFRASTRUCTURE', 1500, 'Device'),
(10, 50, 'https://i.ibb.co/GscYY7c/lawn-mower.png', 'Lawn Mower', 'OUTDOOR', 1500, 'Device'),
(11, 80, 'https://i.ibb.co/mNb4L8p/chainsaw.png', 'Chainsaw', 'OUTDOOR', 2000, 'Device'),
(12, 40, 'https://i.ibb.co/qW8Y5xH/leaf-blower.png', 'Leaf Blower', 'OUTDOOR', 1200, 'Device');

INSERT INTO machine (id, default_footprint, img, name, usage, vehicle_size, vehicle_type, dtype) VALUES
(13, 150, 'https://i.ibb.co/9gqG1GB/small-car.png', 'Small Car', 'TRANSPORT', 'SMALL', 'CAR', 'Vehicle'),
(14, 200, 'https://i.ibb.co/268g5xt/medium-car.png', 'Medium Car', 'TRANSPORT', 'MEDIUM', 'CAR', 'Vehicle'),
(15, 250, 'https://i.ibb.co/wL1GmSF/large-car.png', 'Large Car', 'TRANSPORT', 'LARGE', 'CAR', 'Vehicle');



