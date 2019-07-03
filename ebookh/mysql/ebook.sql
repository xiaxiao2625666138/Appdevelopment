/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : ebook

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 03/07/2019 08:22:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `subtitle` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` mediumint(8) UNSIGNED NULL DEFAULT NULL,
  `translator` mediumint(8) UNSIGNED NULL DEFAULT NULL,
  `publish` smallint(5) UNSIGNED NULL DEFAULT NULL,
  `version` tinyint(3) UNSIGNED NOT NULL,
  `lang` smallint(5) UNSIGNED NULL DEFAULT 1,
  `cover` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `price` float(6, 2) UNSIGNED NULL DEFAULT 0.00,
  `inventory` int(10) UNSIGNED NULL DEFAULT 0,
  `saled` int(10) UNSIGNED NULL DEFAULT 0,
  `score` float(2, 1) UNSIGNED NULL DEFAULT 0.0,
  `score_num` int(10) UNSIGNED NULL DEFAULT 0,
  `logo` int(10) UNSIGNED NULL DEFAULT 0,
  `with_author1` mediumint(8) UNSIGNED NULL DEFAULT NULL,
  `with_author2` mediumint(8) UNSIGNED NULL DEFAULT NULL,
  `with_author3` mediumint(8) UNSIGNED NULL DEFAULT NULL,
  `with_translate1` mediumint(8) UNSIGNED NULL DEFAULT NULL,
  `with_translate2` mediumint(8) UNSIGNED NULL DEFAULT NULL,
  `with_translate3` mediumint(8) UNSIGNED NULL DEFAULT NULL,
  `detail` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isnew` tinyint(4) NULL DEFAULT 1,
  `onsale` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'Y',
  `ISBN` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'QWERTYUIOPASDFGH',
  PRIMARY KEY (`book_id`) USING BTREE,
  INDEX `author`(`author`) USING BTREE,
  INDEX `with_author1`(`with_author1`) USING BTREE,
  INDEX `with_author2`(`with_author2`) USING BTREE,
  INDEX `with_author3`(`with_author3`) USING BTREE,
  INDEX `with_translate1`(`with_translate1`) USING BTREE,
  INDEX `with_translate2`(`with_translate2`) USING BTREE,
  INDEX `with_translate3`(`with_translate3`) USING BTREE,
  INDEX `publish`(`publish`) USING BTREE,
  INDEX `lang`(`lang`) USING BTREE,
  INDEX `translator`(`translator`) USING BTREE,
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`author`) REFERENCES `writer` (`writer_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `book_ibfk_10` FOREIGN KEY (`translator`) REFERENCES `writer` (`writer_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `book_ibfk_2` FOREIGN KEY (`with_author1`) REFERENCES `writer` (`writer_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `book_ibfk_3` FOREIGN KEY (`with_author2`) REFERENCES `writer` (`writer_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `book_ibfk_4` FOREIGN KEY (`with_author3`) REFERENCES `writer` (`writer_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `book_ibfk_5` FOREIGN KEY (`with_translate1`) REFERENCES `writer` (`writer_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `book_ibfk_6` FOREIGN KEY (`with_translate2`) REFERENCES `writer` (`writer_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `book_ibfk_7` FOREIGN KEY (`with_translate3`) REFERENCES `writer` (`writer_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `book_ibfk_8` FOREIGN KEY (`publish`) REFERENCES `press` (`press_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `book_ibfk_9` FOREIGN KEY (`lang`) REFERENCES `language` (`language_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '护身符1', '魔石初现', 1, 2, 1, 1, 1, 'http://localhost:8080/api/img/b1.jpg', 52.00, 14, 5, 7.8, 0, 263168, NULL, NULL, NULL, NULL, NULL, NULL, '蝉联纽约时报畅销榜榜首，获埃森纳奖提名。\r\n风靡美国的木部石蒸汽朋克世界首次与中国读者见面。\r\n体味触动人心的温暖亲情，感悟家对每个人的珍贵。\r\n编辑推荐\r\n精灵、机械兔子、移动城堡，蒸汽朋克世界风靡全美\r\n生活突遭巨变的少女获得了一块魔力无限的魔石，粉红色的兔子操纵着巨大的机器，紧追不舍的邪恶精灵，忽然生出手脚的巨大移动城堡……木部石这本充满奇妙幻想的《护身符》一出版，就迅速席卷全美，刮起了一股新的奇幻风潮，让无数的青少年读者为之疯狂。\r\n这一系列每推出一本新作，就迅速占据亚马逊奇幻类图书的榜首，并霸占纽约时报畅销榜数周之久。\r\n2016年，福斯公司和Temple\nHill\nEntertainment宣布会将《护身符》搬上大荧幕，并邀请《星际迷航》系列编剧撰写剧本。\r\n新锐漫画作家，为哈利波特15周年绘制封面\r\n作者木部石近年来在美国漫画界风头大盛。他的《飞行》为他一举赢得了埃森纳奖提名，图像小说《黛西•库特：最后的火车》更是入选了2006年度青少年最佳读物。\r\n《哈利•波特》系列15出版周年之际，他受邀为这套畅销全球的经典作品绘制了纪念版的封面。\r\n惊险刺激之下的爱与亲情\r\n创作《护身符》之初，木部石就致力于打造一个属于青少年的蒸汽朋克世界。他为这个世界注入了诸多如魔法、机械、天空城之类的青春元素。但不论人物多么时髦，世界观多么奇妙另类，家庭和亲情始终是这个故事的核心，是联结一切的纽带和这个宏大的魔法世界的基石。不论是埃米莉和纳温为了妈妈不顾一切，勇闯陌生世界，还是妈妈为了两个孩子毅然放弃旧日生活，一起加入新世界的冒险，都展现出木部石对“家庭”的重视与信赖。让读者们在体味惊险与刺激之余，亦感受到家人和亲情的重要和可贵。\r\n内容简介\r\n埃米莉一家突遭变故。妈妈带着她和纳温搬到祖宅居住。一家三口希望在那里开始新生活。入住第一天打扫卫生时，埃米莉发现了一枚神奇的护身符。当晚，他们就听到地下室传来诡异的响动。三人前去查看。不料一只长满触须的巨型动物就此劫走了埃米莉和纳温的妈妈。\r\n两个孩子沿着蜿蜒曲折的螺旋楼梯一路追去，进入了奇异的魔法世界。只有埃米和纳温才能挽回一切。他们得发挥自己的聪明才智，想办法营救妈妈。\r\n《护身符》中，木部石为青少年读者们打造了一个绮丽美妙的异想世界，这个世界中魔法与机械巧妙结合，让人感受到别样的美和震撼。而故事中，埃米莉和弟弟为了营救妈妈不惜突破艰难险阻，鼓起勇气一往直前，更让读者体味到家和家人对于每个人的珍贵之处，感受到家庭给人带来的力量和支持。\r\n媒体推荐\r\n精彩的艺术品，充满想象力的人物设计，大胆的色彩运用，让人欲罢不能。奇幻粉丝必读。\r\n——《出版家周刊》\r\n以令人兴奋的分镜呈现出动作片风格的冒险系列，这一系列一定对读者充满吸引力。\r\n——《书单杂志》', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (2, '深入理解计算机系统', NULL, 3, 5, 2, 3, 1, 'http://localhost:8080/api/img/b2.jpg', 139.00, 46, 4, 7.8, 0, 3, 4, NULL, NULL, 6, NULL, NULL, '和第2版相比，本版内容上*大的变化是，从以IA32和x86-64为基础转变为完全以x86-64为基础。主要更新如下：\r\n基于x86-64，大量地重写代码，首次介绍对处理浮点数据的程序的机器级支持。\r\n处理器体系结构修改为支持64位字和操作的设计。\r\n引入更多的功能单元和更复杂的控制逻辑，使基于程序数据流表示的程序性能模型预测更加可靠。\r\n扩充关于用GOT和PLT创建与位置无关代码的讨论，描述了更加强大的链接技术（比如库打桩）。\r\n增加了对信号处理程序更细致的描述，包括异步信号安全的函数等。\r\n采用新函数，更新了与协议无关和线程安全的网络编程。\r\n', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (3, '深入理解计算机系统', NULL, 3, 5, 2, 2, 1, 'http://localhost:8080/api/img/b3.jpg', 99.00, 50, 0, 8.1, 0, 3, 4, NULL, NULL, 7, NULL, NULL, '本书从程序员的视角详细阐述计算机系统的本质概念，并展示这些概念如何实实在在地影响应用程序的正确性、性能和实用性。全书共12章，主要内容包括信息的表示和处理、程序的机器级表示、处理器体系结构、优化程序性能、存储器层次结构、链接、异常控制流、虚拟存储器、系统级I/O、网络编程、并发编程等。书中提供大量的例子和练习，并给出部分答案，有助于读者加深对正文所述概念和知识的理解。\r\n本书的最大优点是为程序员描述计算机系统的实现细节，帮助其在大脑中构造一个层次型的计算机系统，从最底层的数据在内存中的表示到流水线指令的构成，到虚拟存储器，到编译系统，到动态加载库，到最后的用户态应用。通过掌握程序是如何映射到系统上，以及程序是如何执行的，读者能够更好地理解程序的行为为什么是这样的，以及效率低下是如何造成的。\r\n本书适合那些想要写出更快、更可靠程序的程序员阅读，也适合作为高等院校计算机及相关专业本科生、研究生的教材。', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (4, '深入理解计算机系统', NULL, 3, NULL, 2, 3, 2, 'http://localhost:8080/api/img/b4.jpg', 239.00, 50, 0, 7.8, 0, 3, 4, NULL, NULL, NULL, NULL, NULL, '和第2版相比，本版内容上*大的变化是，从以IA32和x86-64为基础转变为完全以x86-64为基础。主要更新如下：\r\n基于x86-64，大量地重写代码，首次介绍对处理浮点数据的程序的机器级支持。\r\n处理器体系结构修改为支持64位字和操作的设计。\r\n引入更多的功能单元和更复杂的控制逻辑，使基于程序数据流表示的程序性能模型预测更加可靠。\r\n扩充关于用GOT和PLT创建与位置无关代码的讨论，描述了更加强大的链接技术（比如库打桩）。\r\n增加了对信号处理程序更细致的描述，包括异步信号安全的函数等。\r\n采用新函数，更新了与协议无关和线程安全的网络编程。\r\n', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (5, '深入理解计算机系统', NULL, 3, NULL, 2, 2, 2, 'http://localhost:8080/api/img/b5.jpg', 128.00, 49, 0, 8.9, 0, 3, 4, NULL, NULL, NULL, NULL, NULL, '本书从程序员的视角详细阐述计算机系统的本质概念，并展示这些概念如何实实在在地影响应用程序的正确性、性能和实用性。全书共12章，主要内容包括信息的表示和处理、程序的机器级表示、处理器体系结构、优化程序性能、存储器层次结构、链接、异常控制流、虚拟存储器、系统级I/O、网络编程、并发编程等。书中提供大量的例子和练习，并给出部分答案，有助于读者加深对正文所述概念和知识的理解。\r\n本书的最大优点是为程序员描述计算机系统的实现细节，帮助其在大脑中构造一个层次型的计算机系统，从最底层的数据在内存中的表示到流水线指令的构成，到虚拟存储器，到编译系统，到动态加载库，到最后的用户态应用。通过掌握程序是如何映射到系统上，以及程序是如何执行的，读者能够更好地理解程序的行为为什么是这样的，以及效率低下是如何造成的。\r\n本书适合那些想要写出更快、更可靠程序的程序员阅读，也适合作为高等院校计算机及相关专业本科生、研究生的教材。', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (6, '数据库系统概念 ', NULL, 8, 11, 2, 6, 1, 'http://localhost:8080/api/img/b6.jpg', 99.00, 50, 0, 8.1, 0, 21, 9, 10, NULL, 12, 13, NULL, '\n十万年前，地球上至少有六种不同的人\r\n\n但今日，世界舞台为什么只剩下了我们自己？\r\n\n从只能啃食虎狼吃剩的残骨的猿人，到跃居食物链顶端的智人，\r\n\n从雪维洞穴壁上的原始人手印，到阿姆斯壮踩上月球的脚印，\r\n\n从认知革命、农业革命，到科学革命、生物科技革命，\r\n\n我们如何登上世界舞台成为万物之灵的？\r\n\n从公元前1776年的《汉摩拉比法典》，到1776年的美国独立宣言，\r\n\n从帝国主义、资本主义，到自由主义、消费主义，\r\n\n从兽欲，到物欲，从兽性、人性，到神性，\r\n\n我们了解自己吗？我们过得更快乐吗？\r\n\n我们究竟希望自己得到什么、变成什么？\r\n\n------------------------------------------------------------------------------------------------\r\n\n【编辑推荐】\r\n\n1、由书改变而成的人类简史课程风靡全球，成为希伯来大学最受欢迎课程\nCoursera最受欢迎课程\n，mooc最受欢迎课程。学界和大众都一致认可，戴蒙德推荐。\r\n\n2、一大开创性：打通文字发明前后历史的界限。\r\n\n文字发明之前的年代，是生物学家、考古学家的专长；文字发明之后的年代，是历史学家、政治学家和经济学家的专长；\r\n\n许多著名史家的作品，欠缺遗传学或生态学的视野，如何让这两大段历史之间没有断层，能够有一以贯之的宏观解读？\r\n\n本书不同于《枪炮、病菌与钢铁》从生物与环境的角度看人类社会的发展，也不同于麦克尼尔的《世界史》以文明为单位绘制的人类文明交织的世界。\n他笔下的历史，在科学中有深沉的人文关怀。\r\n\n3、填补传统人类史的三大鸿沟：\r\n\n历史观与哲学观之间的鸿沟（提供有史实根据的深刻哲学思考）；人类和生态系统之间的鸿沟（作者多从生态来思考，而不是只讲人类的利益）；集体和个人之间的鸿沟（检视历史事件如何影响到当时一般人的生活）。\r\n\n4、四大部分描述人类大历史：\r\n\n7万年前的大脑认知革命（有能力谈八卦，想象不存在的事物，让陌生人开始合作、建立组织）\r\n\n1.2万年前的农业革命（让我们渴求更多、生产更多，分工分职愈趋细腻）、\r\n\n500年前的科学革命（带来快速进步，让我们拥有上帝的力量，也带来毁灭）\r\n\n全球大一统、人类大融合的关键因素——金钱、帝国、宗教\r\n\n5、一部个人幸福探索之书。\r\n\n用通俗的语言和新鲜的视角，将个体的幸福放在人类发展的过程中审视，不再错过历史中最关键、最有意思的部分。涵盖了生物学，人类学，哲学，心理学，艺术，文学，伦理学等众多领域。涉及幸福，生命的意义等众多话题，有人说这是一部个人幸福探索之书。\r\n\n6、一部“瘦身版”人类简史。\r\n\n如果说给我一本书，不到五百页，没有一堆令人晕头转向的年份、人名、地名、称号，就能涵盖了人类如何崛起、影响现代生活甚巨的资本主义、一神教、自由人文主义、基因工程如何兴盛的人类历史重大脉络……这是仅有的一部！\r\n\n7、一部引发多国版权大战的神秘大书。\r\n\n获得波兰斯基人文学科创造力与独创性奖。\n100周蝉联以色列畅销书排行榜第一，在英国，9家出版商疯狂竞价。\n\n23个国家竞相购买版权。台湾上市一周，金石堂、诚品历史类畅销书榜第一\n，诚品总榜第八，西班牙上市两周总榜第一。\r\n\n------------------------------------------------------------------------------------------------\r\n\n【内容简介】\r\n\n《人类简史：从动物到上帝》是以色列新锐历史学家的一部重磅作品。从十万年前有生命迹象开始到21世纪资本、科技交织的人类发展史。十万年前，地球上至少有六个人种，为何今天却只剩下了我们自己？我们曾经只是非洲角落一个毫不起眼的族群，对地球上生态的影响力和萤火虫、猩猩或者水母相差无几。为何我们能登上生物链的顶端，最终成为地球的主宰？\r\n\n从认知革命、农业革命到科学革命，我们真的了解自己吗？我们过得更加快乐吗？我们知道金钱和宗教从何而来，为何产生吗？人类创建的帝国为何一个个衰亡又兴起？为什么地球上几乎每一个社会都有男尊女卑的观念？为何一神教成为最为广泛接受的宗教？科学和资本主义如何成为现代社会最重要的信条？理清影响人类发展的重大脉络，挖掘人类文化、宗教、法律、国家、信贷等产生的根源。这是一部宏大的人类简史，更见微知著、以小写大，让人类重新审视自己。', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (7, '数据库系统概念 ', NULL, 8, 11, 2, 6, 2, 'http://localhost:8080/api/img/b7.jpg', 99.00, 47, 2, 9.1, 0, 21, 9, 10, NULL, 12, 13, NULL, '【编辑推荐】\r\n数据库领域的殿堂级作品\r\n夯实数据库理论基础，增强数据库技术内功的必备之选\r\n对深入理解数据库，深入研究数据库，深入操作数据库都具有极强的指导作用！\r\n【内容简介】\r\n本书是数据库系统方面的经典教材之一，其内容由浅入深，既包含数据库系统基本概念，又反映数据库技术新进展。它被国际上许多著名大学所采用，包括斯坦福大学、耶鲁大学、得克萨斯大学、康奈尔大学、伊利诺伊大学等。我国也有多所大学采用本书作为本科生和研究生数据库课程的教材和主要教学参考书，收到了良好的效果。\r\n第6版保持了前5版的总体风格，同时对内容进行了扩充，对结构进行了调整，以更好地符合数据库教学的需求和反映数据库设计、管理与使用方式的发展和变化。具体更新内容如下：\r\n调整了内容组织结构，将SQL内容提前，并集中进行介绍。\r\n采用一个新的模式（基于大学的数据）作为贯穿全书的运行实例。\r\n修订和更新了对数据存储、索引和查询优化以及分布式数据库的涵盖。\r\n修订了E-R模型、关系设计和事务管理等内容。\r\n扩充了关于应用开发和安全性的素材。\r\n本书配套网站（http://www.db-book.com）提供的教辅资源包括：\r\n·\n书中各章的教学课件。\r\n·\n实践练习的答案。\r\n·\n未放入纸版书中的四个附录（高级关系数据库设计、其他关系查询语言、网状模型、层次模型）。\r\n·\n实验素材（包括大学模式和习题中用到的其他关系的SQL\nDDL和样例数据，以及关于建立和使用各种数据库系统和工具的说明书）。\r\n·\n最新勘误表。', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (8, '返朴 ', NULL, 14, 15, 3, 1, 1, 'http://localhost:8080/api/img/b8.jpg', 49.00, 49, 0, 7.8, 0, 35840, NULL, NULL, NULL, NULL, NULL, NULL, '【编辑推荐】\r\n数据库领域的殿堂级作品\r\n夯实数据库理论基础，增强数据库技术内功的必备之选\r\n对深入理解数据库，深入研究数据库，深入操作数据库都具有极强的指导作用！\r\n【内容简介】\r\n本书是数据库系统方面的经典教材之一，其内容由浅入深，既包含数据库系统基本概念，又反映数据库技术新进展。它被国际上许多著名大学所采用，包括斯坦福大学、耶鲁大学、得克萨斯大学、康奈尔大学、伊利诺伊大学等。我国也有多所大学采用本书作为本科生和研究生数据库课程的教材和主要教学参考书，收到了良好的效果。\r\n第6版保持了前5版的总体风格，同时对内容进行了扩充，对结构进行了调整，以更好地符合数据库教学的需求和反映数据库设计、管理与使用方式的发展和变化。具体更新内容如下：\r\n调整了内容组织结构，将SQL内容提前，并集中进行介绍。\r\n采用一个新的模式（基于大学的数据）作为贯穿全书的运行实例。\r\n修订和更新了对数据存储、索引和查询优化以及分布式数据库的涵盖。\r\n修订了E-R模型、关系设计和事务管理等内容。\r\n扩充了关于应用开发和安全性的素材。\r\n本书配套网站（http://www.db-book.com）提供的教辅资源包括：\r\n·\n书中各章的教学课件。\r\n·\n实践练习的答案。\r\n·\n未放入纸版书中的四个附录（高级关系数据库设计、其他关系查询语言、网状模型、层次模型）。\r\n·\n实验素材（包括大学模式和习题中用到的其他关系的SQL\nDDL和样例数据，以及关于建立和使用各种数据库系统和工具的说明书）。\r\n·\n最新勘误表。', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (9, '风之丘五十元硬币之谜', '里染天马系列04', 16, 17, 4, 1, 1, 'http://localhost:8080/api/img/b9.jpg', 39.00, 49, 0, 6.4, 0, 1024, NULL, NULL, NULL, NULL, NULL, NULL, '“里染天马系列”一部短篇小说集\r\n六个短篇推理故事，将“里染天马系列”三部长篇串联起来\r\n本书将为读者解答：\r\n针宫理惠子为什么把头发染成了黑色？\r\n她为什么愿意在考试的时候帮里染天马？\r\n里染镜华到底是什么人？\r\n……\r\n以及里染天马这个谜之人物的十万个疑难杂症之一二。', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (10, '爱界', NULL, 18, 19, 4, 1, 1, 'http://localhost:8080/api/img/b10.jpg', 45.00, 47, 2, 7.7, 0, 3072, NULL, NULL, NULL, NULL, NULL, NULL, '去不去爱，爱的界限何在，一直是普拉克西丝的人生课题。\r\n年迈的她独自待在肮脏而昏暗的地下室里，想写回忆录，可她该写些什么呢？是写父母未婚同居生下了她，她还年幼天真无邪时，母女就遭父亲抛弃？还是写她曾经或是主动或是被动地成了未婚同居者、妻子、情人、母亲、后母？还是写她两年的牢狱生活？她想描绘二十世纪女性的众生相，想记录女性群体在情感、灵魂和思想方面所处的三重困境，想道出女性之间的大爱如何铸成姐妹之谊。\r\n《爱界》出自英国重量级作家费伊·韦尔登之手，入围布克奖决选名单，荣登《泰晤士报》“年度图书”榜。', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (11, '空港', '云霄路上', 20, NULL, 5, 1, 1, 'http://localhost:8080/api/img/b11.jpg', 49.80, 47, 2, 7.7, 0, 1024, NULL, NULL, NULL, NULL, NULL, NULL, '这是一条熙熙攘攘的云霄路，路的尽头通往机场，路的此端连接着空乘人员烟火气十足的生活。航空公司新人王泳觉得最近很倒霉：她得罪了不该得罪的金卡旅客，被分去不想去的部门。更倒霉的是，当她搬到新住所时，发现邻居正是当日投诉她的旅客，秦希。\r\n她的新工作坎坷颇多，充满挑战，在经过过了最初的不适应阶段后，王泳与同事胡昊结成好友。两人不但在日常工作中合作顺利，还被委以海外紧急撤侨的重任。\r\n看似职场生涯即将一帆风顺地展开，王泳却发现胡昊接近自己的目的似乎不那么简单。与此同时，胡昊与秦希的过往渐渐浮出水面……\r\n对王泳来说，有三样东西最难以捉摸：胡昊的内心、秦希的过往、自己的未来。', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (12, '基本穿搭', NULL, 21, 22, 6, 1, 1, 'http://localhost:8080/api/img/b12.jpg', 45.00, 45, 1, 8.1, 0, 64, NULL, NULL, NULL, NULL, NULL, NULL, '不理潮流、不浪费时间和金钱\r\n简简单单就能完成80分的搭配\r\n日本超人气造型师大山旬亲自传授能够改变人生的穿衣法则\r\n--------------------\r\n编辑推荐\r\n你是不是也有这样的困扰？\r\n每天对着满满当当的衣柜，依然拿不出想穿的衣服；\r\n精心挑选的衣服，却怎么都搭配不出理想的效果；\r\n想要穿得简洁时尚，又不\n知该如何开始改造，等等\r\n本书就是为深陷在这些困扰中的普通人量身打造的。\r\n--------------------\r\n内容简介\r\n对穿衣搭配感到不耐烦，认为时尚很麻烦，穿什么都可以或者对衣服有着自己的想法但不够自信，本书就是为这样的人而准备的穿衣指南。不需要追随瞬息万变的时尚潮流，也不需要烦恼色彩搭配，只要掌握最低限度的知识和备齐常规单品，谁都能完成清爽得体的\n80分搭配。', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (13, '冒牌人生', NULL, 23, NULL, 7, 1, 1, 'http://localhost:8080/api/img/b13.jpg', 45.00, 48, 1, 7.7, 0, 3072, NULL, NULL, NULL, NULL, NULL, NULL, '发生在光辉都市里的怪诞故事\r\n独立艺术家徐冰好评推荐\r\n编辑推荐\r\n十篇现代志怪小说，如同十道城市之光，划开机械冷酷的城市外壳，让不合时宜者出来透透气。\r\n作者陈思安兼具小说家、诗人、戏剧导演的多重身份，擅长将写实性与传奇性巧妙结合，抒写繁华都市中的荒诞人生。\r\n《\n冒牌人生》试图抵抗城市生活对人的异化，以奇人异事来重绘城市的精神地图，小说中的人物能够直面孤独、平庸和无意义，最终通过某种荒诞的方式走出生活困境，正是这样一群人，丰富了城市生活的面貌，由此可见作者的社会关怀：所有生活工作在城市中的“冒牌人生”都值得被认真对待和记录。\r\n内容简介\r\n《冒牌人生》收录了十篇短篇小说。十个故事分别以城市中的怪人为主角，他们默默无闻地生存在城市主流生活的边缘地带：或是等待手术的性别认同障碍者，或是武艺高强而深藏不露的夜市摊主，或是卧底追凶的底层保安，或是甘于流浪生活的地铁游侠……无论是表面上的冒牌人生，还是暗地里的怪客人生，它们都是组成城市复杂面貌的不可或缺的重要部分。故事内容充满戏剧性，写作手法上也有所创新。\r\n名人推荐\r\n思安的文字像自问自答，字句间有一种特别的节奏，这节奏，不知不觉就把读者带进去了，也跟着、舒服的、碎碎叨叨，自问自答起来。\r\n今天的世界由微信、广告等各种碎语搭建，世界也变了成变成了碎碎叨叨的世界。有文化情怀的思安，却生活在了这个“碎阅读”时代，纠结于她的写作间，倒是让她的文字变得特殊起来。——徐冰', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (14, '爱情就是堆积如山的笔记 ', NULL, 24, NULL, 8, 1, 1, 'http://localhost:8080/api/img/b14.jpg', 45.00, 50, 0, 9.1, 0, 34816, NULL, NULL, NULL, NULL, NULL, NULL, '本书以《第凡尼早餐》《情人》《包法利夫人》《霍乱时期的爱情》《老妇还乡》《革命之路》《聊斋志异》等10部名著中的女性角色为书写对象，通过对书中人物的遭遇和命运的剖析，来解读古往今来女性的诸多生存现实和自我救赎之路，尤其重点剖析了当下女性所处的困境和应对之策，呈现出作者对女性这一身份的深入思考、对女性觉醒的向往、和为唤醒女性付出的努力。困局、复仇、信任、浮华、暴力……苏美以其特有的毒舌，以名著为参照，深入解读当下爱情与婚姻中的困境与真相。', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (15, '勃朗特姐妹', '权力的神话', 25, 26, 9, 1, 1, 'http://localhost:8080/api/img/b15.jpg', 48.00, 49, 1, 8.1, 0, 2048, NULL, NULL, NULL, NULL, NULL, NULL, '这三姐妹踏出约克郡教区那片文明飞地，进入无人保护的世界，她们被迫成为家庭教师，把自己所受的教育作为商品兜售。她们身上记录了文明与粗蛮的冲突、教养与劳作的冲突、自我表达与自我压抑的冲突，无处不彰显出社会存在的新形式。\r\n这是当时我所写过的最有理论雄心的一本书，尽管它关注的是经典作家，但我觉得它在理论上是有突破的。\r\n——特里·伊格尔顿\r\n-------------------------\r\n《权力的神话》是英国著名批评家伊格尔顿关于勃朗特姐妹的几部为人所熟知的作品——《简·爱》《呼啸山庄》《谢莉》《教师》《维莱特》《艾格妮丝·格雷》的解读。伊格尔顿从小说文本和勃朗特姐妹所生活的历史背景与家庭环境出发，试图回答这样一个问题：在勃朗特姐妹的小说和她们所处的社会之间，是一种怎样的关系？\r\n勃朗特姐妹生活在18世纪与19世纪之交，也即从田园牧歌式的浪漫主义，向英国工业资本主义开始转型的时代。一方面，身为牧师的女儿，她们有机会接受体面的教育，却因为迫于生计不得不做家庭教师，寄人篱下；另一方面，当工业革命正在她们家的门口如火如荼地展开，大规模的劳工运动也就此复兴。这种时代的交替在她们身上留下明显的烙印，“对异见者既同情又恐惧，对当局既心存不满又满怀敬仰”，恰如其分地体现了她们作为中低阶层在转型时代所特有的一种摇摆立场。\r\n站在新时代的端口，在迈向城市化的英国社会里，人们正在学习新的感受方式，压抑、顺从和形塑自我；人们也有新的主体模式，既热情不断又挫折不断，既孤立无依又聪明自立，此般分裂式的处境在她们的小说中有充分而自由地展现。\r\n当然，勃朗特姐妹的个性迥异，这也造就了她们的小说内容的不同发展趋势。相比夏洛特·勃朗特的“适度妥协”，艾米丽·勃朗特的性格则更显“激烈决绝”，正如他们的主人公在《简·爱》和《呼啸山庄》中表现出来的一样。\r\n本书于1975年在英国首次出版，当时这种把作品放到作家生活的历史背景中去看的眼光还是独到而先锋的。哪怕是经历过1968年巴黎文化运动的年轻人，对他们来说，《权力的神话》也还是一种不成熟的构想，犹如政治疾风中的一芥稻草。到了1988年再版时，这本书引起了众多人的重视，女性主义者已开始批评伊格尔顿的作品忽视了勃朗特姐妹的性别特征。2005年又出了30周年纪念版，伊格尔顿在序言中坦陈女性身份的特质确实应作为重要因素考虑在其中。', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (16, '目送', '龙应台“人生三书”之三', 27, NULL, 10, 1, 1, 'http://localhost:8080/api/img/b16.jpg', 43.00, 49, 0, 7.8, 0, 67648, NULL, NULL, NULL, NULL, NULL, NULL, '《目送：龙应台“人生三书”之三》——21世纪的《背影》\n+\n感人至深的“生死笔记”+\n龙应台亲手摄影\n+\n跨三代共读的人生之书……\r\n“有些路啊，只能一个人走……”\r\n龙应台的文字，“横眉冷对千夫指”时，寒气逼人，如刀光剑影。“俯首甘为孺子牛”时，却温柔婉转，彷佛微风吹过麦田。从纯真喜悦的“人生三书”之一《孩子你慢慢来》，到坦率得近乎“痛楚”的“人生三书”之二《亲爱的安德烈》，龙应台的写作境界逐渐转往人生的深沉。\r\n《目送》的七十四篇散文，写父亲的逝、母亲的老、儿子的离、朋友的牵挂、兄弟的携手共行，写失败和脆弱、失落和放手，写缠绵不舍和绝然的虚无。她写尽了幽微，如烛光冷照山壁。\r\n这是一本生死笔记，深邃，忧伤，美丽。\r\n龙应台说：“我慢慢地、慢慢地了解到，所谓父女母子一场，只不过意味着，你和他的缘分就是今生今世不断地在目送他的背影渐行渐远。你站在小路的这一端，看着他逐渐消失在小路转弯的地方，而且，他用背影默默地告诉你，不必追。”', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (17, '天长地久', '给美君的信', 27, NULL, 3, 1, 1, 'http://localhost:8080/api/img/b17.jpg', 58.00, 48, 1, 7.7, 0, 67840, NULL, NULL, NULL, NULL, NULL, NULL, '美君来自浙江。她二十岁爱上的男子，来自湖南。\r\n他们走过的路，是万里江山，满目烟尘；\r\n怀着“温情与敬意”，我感恩他们的江山、他们的烟尘，\r\n给了我天大地大、气象万千的一座教室，上生命的课。\r\n人生里有些事，就是不能蹉跎……\r\n禁语行禅时龙应台瞬间决定：\r\n放下一切，回乡陪伴失智的\n母亲，开始写信\r\n——————————————————————————\r\n龙应台阔别十年，2018推出重磅新作。横扫台湾、香港畅销书榜，引爆华人社会热议。\r\n一堂学校不教的生命课，一份诚挚勇敢的生死书。继《孩子你慢慢来》《亲爱的安德烈》《目送》后，龙应台以更坦率更深情之笔，丈量爱与生命的丰厚与辽阔。\r\n全书复调结构，独具匠心。她潜心10年，延续以往受读者欢迎的亲情主题，融入历史元素，比以往作品更有深度，视角更开阔、书写更细腻、立意更高远。\r\n19封给母亲的信，写满对亲情、亲子、生命、教育与岁月的思索。穿插35篇从数千件珍贵材料中筛选出的“大河图文”，跨度长达50年，将个人情感烙在真实历史上。\r\n装帧精美，特别典藏，让读者阅读其中，仿佛时空穿梭，体会上一代的颠沛人生。全彩四色印刷，由台湾获奖设计团队进行包装、设计。主文是信件形式，历史图文是明信片形式穿插其中。封面字选自王羲之《兰亭集序》，封面由作者亲自选定。\r\n作者为大陆版耗时数月，几经修改，撰写亲笔序。', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (18, '孩子你慢慢来 ', '龙应台“人生三书”之一', 27, NULL, 10, 1, 1, 'http://localhost:8080/api/img/b18.jpg', 29.80, 47, 2, 6.4, 0, 84032, NULL, NULL, NULL, NULL, NULL, NULL, '《孩子你慢慢来：龙应台“人生三书”之一》——\n20周年经典新版“母子之书”\n+\n50后妈妈\n+\n80后孩子\n+\n“家有二胎”的成长镜头……\r\n作为华人世界率性犀利的一枝笔，龙应台的文章有万丈豪气，然而《孩子你慢慢来》却令人惊叹，她的文字也可以有万丈深情。\r\n这本书里的龙应台是一个母亲，与生命的本质和起点素面相对，作最深刻的思索，最不思索的热爱。面对初生至童年、少年时期的两个孩子（华飞、华安），从出生，到开始说话、识字、逐渐认识这个世界，书中有忍俊不禁的童真，有无法抑制的爱怜，也有母子的无奈和迷惑。它不是对传统母职的歌颂，它是对生命的实景写生，只有真正懂得爱的作家才写得出这样的生活散文。\r\n后来，15岁的“底笛”（弟弟）说：“有时候，妈妈带我们在草原上放风筝。草原那么大，草绿得出水，我们躺下来，看风筝在天空里飞。我觉得我可以一辈子躺在那里。”\r\n后来，19岁的“葛格”（哥哥）说：“尽管我们之间一直有这种成长的‘拔河’，母亲却仍然以一种安静的、潜移默化的方式，把我教育成了一个，用她的语言来说，‘像一株小树一样正直’的人。”\r\n而最初，34岁的母亲（龙应台）说：“我，坐在斜阳浅照的台阶上，望着这个眼睛清亮的小孩专心地做一件事；是的，我愿意等上一辈子的时间，让他从从容容地把这个蝴蝶结扎好，用他五岁的手指。孩子你慢慢来，慢慢来。”', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (19, '雨季不再来', NULL, 28, NULL, 11, 1, 1, 'http://localhost:8080/api/img/b19.jpg', 28.00, 49, 1, 7.7, 0, 133376, NULL, NULL, NULL, NULL, NULL, NULL, '《雨季不再来》以三毛的生命历程为主题，记录了三毛17岁到22岁的成长过程，真实呈现出三毛少女时代的成长感受，辍学、自闭、叛逆，游学西班牙、德国、美国后，渐渐成长为独立自信的青年，这本书中透露的纯真情怀和异质美感，可以清楚地印证她传奇性格的痕迹。', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (20, '文化苦旅', '余秋雨三十年散文自选集', 29, NULL, 12, 1, 1, 'http://localhost:8080/api/img/b20.jpg', 38.00, 48, 1, 7.7, 0, 2304, NULL, NULL, NULL, NULL, NULL, NULL, '《文化苦旅》一书于1992年首次出版，是余秋雨先生1980年代在海内外讲学和考察途中写下的作品，是他的第一部文化散文集。全书主要包括两部分，一部分为历史、文化散文，另一部分为回忆散文。甫一面世，该书就以文采飞扬、知识丰厚、见解独到而备受万千读者喜爱。由此开创“历史大散文”一代文风，令世人重拾中华文化价值。他的散文别具一格，见常人所未见，思常人所未思，善于在美妙的文字中一步步将读者带入历史文化长河，启迪哲思，引发情致，具有极高的审美价值和史学、文化价值。书中多篇文章后入选中学教材。但由于此书的重大影响，在为余秋雨先生带来无数光环和拥趸的同时，也带来了数之不尽的麻烦和盗版。誉满天下，“谤”亦随身。余秋雨先生在身心俱疲之下，决定亲自修订、重编此书。\r\n新版《文化苦旅》作为余秋雨先生30年历史文化散文修订自选集，删掉旧版37篇文章中的13篇，新增文章17篇，其中入选教材的《道士塔》《莫高窟》《都江堰》等经典篇目全部经过改写、修订。新版内容与旧版相比，全新和改写的篇目达到三分之二以上，对新老读者都是一场全新的阅读体验和人文享受。堪称余秋雨30年来不懈的文化考察和人生思索的完美结晶。', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (21, '城南旧事', '纪念普及版', 30, NULL, 13, 1, 1, 'http://localhost:8080/api/img/b21.jpg', 16.00, 49, 0, 8.1, 0, 3072, NULL, NULL, NULL, NULL, NULL, NULL, '多少年来，《城南旧事》感动了一代又一代的读者，除了再版无数次的小说版外，1985年，本书在中国大陆搬上银幕，电影“城南旧事”获得“中国电影金鸡奖”、第二届“马尼拉国际电影节最佳故事片奖金鹰奖章”、第十四届“贝尔格勒国际儿童电影节最佳影片思想奖”等多项大奖。\r\n儿童绘本版《城南旧事》由当今中国极具代表性的水彩画家关维兴，运用优雅诗意的风格和穿透人心的独到技巧，将创作的图画全然融入故事的情节。画中举凡服饰、器物和建筑，考据详实，没一点随便或含糊。人物细致的表情、光线和空气的律动、圆熟丰美的调子，使文图呈现无懈可击的呼应。绘本《城南旧事》甫出版即获选1993、1994年“波隆那国际儿童书插画展”、1993年“布拉迪斯国际插画双年展”以及1994年“加泰隆尼亚国际插画双年展”。\r\n从小说到电影，从成人书到儿童绘本，《城南旧事》是故事、是梦幻，读时仿若音乐，轻轻扣动人心，字里行间所隐涵的深意，更令人撼动，久久不能自已。\r\n', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (22, 'Linux从入门到精通', NULL, 31, NULL, 14, 1, 1, 'http://localhost:8080/api/img/b22.jpg', 59.00, 49, 0, 7.8, 0, 18, NULL, NULL, NULL, NULL, NULL, NULL, 'linux是目前增长最迅速的操作系统。本书由浅入深、循序渐进地向读者介绍linux的基本使用和系统管理。全书内容包括linux概述、linux安装、linux基本配置、桌面环境基本操作、shell基本命令、文件和目录管理、软件包管理、磁盘管理、用户与用户组管理、进程管理、网络配置、浏览网页、收发邮件、文件传输和共享、远程登录、多媒体应用、图像浏览和处理、打印机配置、办公软件的使用、linux编程工具、shell编程、服务器基础知识、apache服务器、vsftpd服务器、samba服务器、nfs服务器、任务计划、防火墙和网络安全、病毒和木马防范。\r\n', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (23, '图解HTTP', NULL, 32, 33, 15, 1, 1, 'http://localhost:8080/api/img/b23.jpg', 49.00, 48, 0, 7.7, 0, 4114, NULL, NULL, NULL, NULL, NULL, NULL, '本书对互联网基盘——HTTP协议进行了全面系统的介绍。作者由HTTP协议的发展历史娓娓道来，严谨细致地剖析了HTTP协议的结构，列举诸多常见通信场景及实战案例，最后延伸到Web安全、最新技术动向等方面。本书的特色为在讲解的同时，辅以大量生动形象的通信图例，更好地帮助读者深刻理解HTTP通信过程中客户端与服务器之间的交互情况。读者可通过本书快速了解并掌握HTTP协议的基础，前端工程师分析抓包数据，后端工程师实现REST\nAPI、实现自己的HTTP服务器等过程中所需的HTTP相关知识点本书均有介绍。\r\n本书适合Web开发工程师，以及对HTTP协议感兴趣的各层次读者。\r\n', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (24, 'C程序设计语言', NULL, 34, 36, 2, 2, 1, 'http://localhost:8080/api/img/b24.jpg', 30.00, 50, 0, 8.1, 0, 18, 35, NULL, NULL, 37, NULL, NULL, '在计算机发展的历史上，没有哪一种程序设计语言像C语言这样应用广泛。本书原著即为C语言的设计者之一Dennis\nM.Ritchie和著名计算机科学家Brian\nW.Kernighan合著的一本介绍C语言的权威经典著作。我们现在见到的大量论述C语言程序设计的教材和专著均以此书为蓝本。原著第1版中介绍的C语言成为后来广泛使用的C语言版本——标准C的基础。人们熟知的“hello,World\"程序就是由本书首次引入的，现在，这一程序已经成为众多程序设计语言入门的第一课。\r\n原著第2版根据1987年制定的ANSIC标准做了适当的修订．引入了最新的语言形式，并增加了新的示例，通过简洁的描述、典型的示例，作者全面、系统、准确地讲述了C语言的各个特性以及程序设计的基本方法。对于计算机从业人员来说，《C程序设计语言》是一本必读的程序设计语\n言方面的参考书。', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (25, 'Java编程思想', NULL, 38, 39, 2, 4, 1, 'http://localhost:8080/api/img/b25.jpg', 108.00, 49, 0, 8.9, 0, 18, NULL, NULL, NULL, NULL, NULL, NULL, '本书赢得了全球程序员的广泛赞誉，即使是最晦涩的概念，在Bruce\nEckel的文字亲和力和小而直接的编程示例面前也会化解于无形。从Java的基础语法到最高级特性（深入的面向对象概念、多线程、自动项目构建、单元测试和调试等），本书都能逐步指导你轻松掌握。\r\n从本书获得的各项大奖以及来自世界各地的读者评论中，不难看出这是一本经典之作。本书的作者拥有多年教学经验，对C、C++以及Java语言都有独到、深入的见解，以通俗易懂及小而直接的示例解释了一个个晦涩抽象的概念。本书共22章，包括操作符、控制执行流程、访问权限控制、复用类、多态、接口、通过异常处理错误、字符串、泛型、数组、容器深入研究、Java\nI/O系统、枚举类型、并发以及图形化用户界面等内容。这些丰富的内容，包含了Java语言基础语法以及高级特性，适合各个层次的Java程序员阅读，同时也是高等院校讲授面向对象程序设计语言以及Java语言的绝佳教材和参考书。\r\n第4版特点：\r\n适合初学者与专业人员的经典的面向对象叙述方式，为更新的Java\nSE5/6增加了新的示例和章节。\r\n\n测验框架显示程序输出。\r\n', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (26, '从Python开始学编程', NULL, 40, NULL, 16, 1, 1, 'http://localhost:8080/api/img/b26.jpg', 49.00, 48, 1, 7.8, 0, 18, NULL, NULL, NULL, NULL, NULL, NULL, '改编自Vamei博客的《Python快速教程》。本书以Python为样本，不仅介绍了编程的基本概念，还着重讲解编程语言的主流范式：面向过程、面向对象、面向函数。读者不仅可以轻松学会Python，以后再学习其他编程语言时也会更加容易。', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (27, '程序员修炼之道', '从小工到专家', 41, 43, 16, 1, 1, 'http://localhost:8080/api/img/b27.jpg', 48.00, 49, 1, 6.4, 0, 18, 42, NULL, NULL, NULL, NULL, NULL, '《程序员修炼之道》由一系列的独立的部分组成，涵盖的主题从个人责任、职业发展，直到用于使代码保持灵活、并且易于改编和复用的各种架构技术。利用许多富有娱乐性的奇闻轶事、有思想性的例子以及有趣的类比，全面阐释了软件开发的许多不同方面的最佳实践和重大陷阱。无论你是初学者，是有经验的程序员，还是软件项目经理，本书都适合你阅读。', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (28, 'Python深度学习', NULL, 44, 45, 15, 1, 1, 'http://localhost:8080/api/img/b28.jpg', 119.00, 49, 0, 9.1, 0, 18, NULL, NULL, NULL, NULL, NULL, NULL, '本书由Keras之父、现任Google人工智能研究员的弗朗索瓦•肖莱（François\nChollet）执笔，详尽介绍了用Python和Keras进行深度学习的探索实践，涉及计算机视觉、自然语言处理、生成式模型等应用。书中包含30多个代码示例，步骤讲解详细透彻。由于本书立足于人工智能的可达性和大众化，读者无须具备机器学习相关背景知识即可展开阅读。在学习完本书后，读者将具备搭建自己的深度学习环境、建立图像识别模型、生成图像和文字等能力。\r\n', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (29, '深度学习入门', '基于Python的理论与实现', 46, 47, 15, 1, 1, 'http://localhost:8080/api/img/b29.jpg', 59.00, 49, 1, 7.7, 0, 18, NULL, NULL, NULL, NULL, NULL, NULL, '本书是深度学习真正意义上的入门书，深入浅出地剖析了深度学习的原理和相关技术。书中使用Python3，尽量不依赖外部库或工具，从基本的数学知识出发，带领读者从零创建一个经典的深度学习网络，使读者在此过程中逐步理解深度学习。书中不仅介绍了深度学习和神经网络的概念、特征等基础知识，对误差反向传播法、卷积神经网络等也有深入讲解，此外还介绍了深度学习相关的实用技巧，自动驾驶、图像生成、强化学习等方面的应用，以及为什么加深层可以提高识别精度等“为什么”的问题。', 1, 'Y', 'QWERTYUIOPASDFGH');
INSERT INTO `book` VALUES (30, '人类简史', '从动物到上帝', 48, 49, 9, 1, 1, 'http://localhost:8080/api/img/b30.jpg', 68.00, 50, 0, 8.1, 0, 32, NULL, NULL, NULL, NULL, NULL, NULL, '\n十万年前，地球上至少有六种不同的人\n\n但今日，世界舞台为什么只剩下了我们自己？\n\n从只能啃食虎狼吃剩的残骨的猿人，到跃居食物链顶端的智人，\n\n从雪维洞穴壁上的原始人手印，到阿姆斯壮踩上月球的脚印，\n\n从认知革命、农业革命，到科学革命、生物科技革命，\n\n我们如何登上世界舞台成为万物之灵的？\n\n从公元前1776年的《汉摩拉比法典》，到1776年的美国独立宣言，\n\n从帝国主义、资本主义，到自由主义、消费主义，\n\n从兽欲，到物欲，从兽性、人性，到神性，\n\n我们了解自己吗？我们过得更快乐吗？\n\n我们究竟希望自己得到什么、变成什么？\n\n------------------------------------------------------------------------------------------------\n\n【编辑推荐】\n\n1、由书改变而成的人类简史课程风靡全球，成为希伯来大学最受欢迎课程\nCoursera最受欢迎课程\n，mooc最受欢迎课程。学界和大众都一致认可，戴蒙德推荐。\n\n2、一大开创性：打通文字发明前后历史的界限。\n\n文字发明之前的年代，是生物学家、考古学家的专长；文字发明之后的年代，是历史学家、政治学家和经济学家的专长；\n\n许多著名史家的作品，欠缺遗传学或生态学的视野，如何让这两大段历史之间没有断层，能够有一以贯之的宏观解读？\n\n本书不同于《枪炮、病菌与钢铁》从生物与环境的角度看人类社会的发展，也不同于麦克尼尔的《世界史》以文明为单位绘制的人类文明交织的世界。\n他笔下的历史，在科学中有深沉的人文关怀。\n\n3、填补传统人类史的三大鸿沟：\n\n历史观与哲学观之间的鸿沟（提供有史实根据的深刻哲学思考）；人类和生态系统之间的鸿沟（作者多从生态来思考，而不是只讲人类的利益）；集体和个人之间的鸿沟（检视历史事件如何影响到当时一般人的生活）。\n\n4、四大部分描述人类大历史：\n\n7万年前的大脑认知革命（有能力谈八卦，想象不存在的事物，让陌生人开始合作、建立组织）\n\n1.2万年前的农业革命（让我们渴求更多、生产更多，分工分职愈趋细腻）、\n\n500年前的科学革命（带来快速进步，让我们拥有上帝的力量，也带来毁灭）\n\n全球大一统、人类大融合的关键因素——金钱、帝国、宗教\n\n5、一部个人幸福探索之书。\n\n用通俗的语言和新鲜的视角，将个体的幸福放在人类发展的过程中审视，不再错过历史中最关键、最有意思的部分。涵盖了生物学，人类学，哲学，心理学，艺术，文学，伦理学等众多领域。涉及幸福，生命的意义等众多话题，有人说这是一部个人幸福探索之书。\n\n6、一部“瘦身版”人类简史。\n\n如果说给我一本书，不到五百页，没有一堆令人晕头转向的年份、人名、地名、称号，就能涵盖了人类如何崛起、影响现代生活甚巨的资本主义、一神教、自由人文主义、基因工程如何兴盛的人类历史重大脉络……这是仅有的一部！\n\n7、一部引发多国版权大战的神秘大书。\n\n获得波兰斯基人文学科创造力与独创性奖。\n100周蝉联以色列畅销书排行榜第一，在英国，9家出版商疯狂竞价。\n\n23个国家竞相购买版权。台湾上市一周，金石堂、诚品历史类畅销书榜第一\n，诚品总榜第八，西班牙上市两周总榜第一。\n\n------------------------------------------------------------------------------------------------\n\n【内容简介】\n\n《人类简史：从动物到上帝》是以色列新锐历史学家的一部重磅作品。从十万年前有生命迹象开始到21世纪资本、科技交织的人类发展史。十万年前，地球上至少有六个人种，为何今天却只剩下了我们自己？我们曾经只是非洲角落一个毫不起眼的族群，对地球上生态的影响力和萤火虫、猩猩或者水母相差无几。为何我们能登上生物链的顶端，最终成为地球的主宰？\n\n从认知革命、农业革命到科学革命，我们真的了解自己吗？我们过得更加快乐吗？我们知道金钱和宗教从何而来，为何产生吗？人类创建的帝国为何一个个衰亡又兴起？为什么地球上几乎每一个社会都有男尊女卑的观念？为何一神教成为最为广泛接受的宗教？科学和资本主义如何成为现代社会最重要的信条？理清影响人类发展的重大脉络，挖掘人类文化、宗教、法律、国家、信贷等产生的根源。这是一部宏大的人类简史，更见微知著、以小写大，让人类重新审视自己。', 1, 'Y', 'QWERTYUIOPASDFGH');

-- ----------------------------
-- Table structure for eorder
-- ----------------------------
DROP TABLE IF EXISTS `eorder`;
CREATE TABLE `eorder`  (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_id` int(11) NULL DEFAULT NULL,
  `book_num` tinyint(4) NULL DEFAULT 1,
  `paid` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'N',
  `time` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `chosen` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'N',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `user_name`(`user_name`) USING BTREE,
  INDEX `book_id`(`book_id`) USING BTREE,
  CONSTRAINT `eorder_ibfk_1` FOREIGN KEY (`user_name`) REFERENCES `euser` (`user_name`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `eorder_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 195 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of eorder
-- ----------------------------
INSERT INTO `eorder` VALUES (116, 'zhang', 6, 4, 'Y', '2019-04-25 13:20:08', 'N');
INSERT INTO `eorder` VALUES (119, 'zhang', 1, 15, 'Y', '2019-04-25 14:27:03', 'N');
INSERT INTO `eorder` VALUES (129, 'zhang', 1, 15, 'Y', '2019-04-27 14:24:11', 'N');
INSERT INTO `eorder` VALUES (130, 'zhang', 12, 4, 'Y', '2019-04-27 14:24:11', 'N');
INSERT INTO `eorder` VALUES (132, 'zhang', 21, 1, 'Y', '2019-04-27 14:24:11', 'N');
INSERT INTO `eorder` VALUES (133, 'zhang', 20, 1, 'Y', '2019-04-27 14:24:11', 'N');
INSERT INTO `eorder` VALUES (136, 'zhang', 5, 1, 'Y', '2019-04-27 14:24:11', 'N');
INSERT INTO `eorder` VALUES (137, 'zhang', 1, 1, 'Y', '2019-04-27 17:48:08', 'N');
INSERT INTO `eorder` VALUES (138, 'zhang', 8, 1, 'Y', '2019-04-27 17:48:08', 'N');
INSERT INTO `eorder` VALUES (139, 'zhang', 9, 1, 'Y', '2019-04-27 17:48:08', 'N');
INSERT INTO `eorder` VALUES (140, 'zhang', 23, 1, 'Y', '2019-04-27 17:48:08', 'N');
INSERT INTO `eorder` VALUES (141, 'zhang', 22, 1, 'Y', '2019-04-27 17:48:24', 'N');
INSERT INTO `eorder` VALUES (142, 'zhang', 23, 1, 'Y', '2019-04-27 17:48:24', 'N');
INSERT INTO `eorder` VALUES (143, 'zhang', 1, 1, 'Y', '2019-04-27 21:18:35', 'N');
INSERT INTO `eorder` VALUES (144, 'zhang', 10, 1, 'Y', '2019-04-27 21:18:35', 'N');
INSERT INTO `eorder` VALUES (145, 'zhang', 11, 1, 'Y', '2019-04-27 21:18:35', 'N');
INSERT INTO `eorder` VALUES (146, 'zhang', 13, 1, 'Y', '2019-04-27 21:18:35', 'N');
INSERT INTO `eorder` VALUES (147, 'zhang', 16, 1, 'Y', '2019-04-27 21:18:55', 'N');
INSERT INTO `eorder` VALUES (148, 'zhang', 17, 1, 'Y', '2019-04-27 21:18:55', 'N');
INSERT INTO `eorder` VALUES (149, 'zhang', 18, 1, 'Y', '2019-04-27 21:18:55', 'N');
INSERT INTO `eorder` VALUES (150, 'zhang', 25, 1, 'Y', '2019-04-27 21:18:55', 'N');
INSERT INTO `eorder` VALUES (151, 'zhang', 26, 1, 'Y', '2019-04-27 21:18:55', 'N');
INSERT INTO `eorder` VALUES (152, 'zhang', 28, 1, 'Y', '2019-04-27 21:18:55', 'N');
INSERT INTO `eorder` VALUES (153, 'zhang', 7, 1, 'Y', '2019-04-27 21:18:55', 'N');
INSERT INTO `eorder` VALUES (155, 'zhang', 10, 1, 'Y', '2019-04-28 22:16:08', 'N');
INSERT INTO `eorder` VALUES (156, 'zhang', 11, 1, 'Y', '2019-04-28 22:16:17', 'N');
INSERT INTO `eorder` VALUES (157, 'zhang', 13, 1, 'Y', '2019-04-28 22:16:08', 'N');
INSERT INTO `eorder` VALUES (159, 'zhang', 18, 1, 'Y', '2019-04-28 22:16:08', 'N');
INSERT INTO `eorder` VALUES (161, 'zhang', 2, 1, 'Y', '2019-04-28 22:16:17', 'N');
INSERT INTO `eorder` VALUES (162, 'zhang', 12, 1, 'Y', '2019-04-28 22:16:17', 'N');
INSERT INTO `eorder` VALUES (163, 'zhang', 20, 1, 'Y', '2019-04-28 22:16:08', 'N');
INSERT INTO `eorder` VALUES (164, 'zhang', 2, 1, 'Y', '2019-04-28 22:35:03', 'N');
INSERT INTO `eorder` VALUES (165, 'zhang', 18, 1, 'Y', '2019-04-28 22:35:03', 'N');
INSERT INTO `eorder` VALUES (166, 'zhang', 17, 1, 'Y', '2019-04-29 13:18:23', 'N');
INSERT INTO `eorder` VALUES (167, 'zhang', 27, 1, 'Y', '2019-04-29 13:18:23', 'N');
INSERT INTO `eorder` VALUES (168, 'zhang', 26, 1, 'Y', '2019-04-29 13:18:23', 'N');
INSERT INTO `eorder` VALUES (171, 'zhang', 1, 1, 'Y', '2019-04-29 13:34:00', 'N');
INSERT INTO `eorder` VALUES (172, 'zhang', 2, 1, 'Y', '2019-04-29 13:34:00', 'N');
INSERT INTO `eorder` VALUES (175, 'zhang', 29, 1, 'Y', '2019-04-29 13:34:00', 'N');
INSERT INTO `eorder` VALUES (176, 'zhang', 19, 1, 'Y', '2019-04-29 13:34:00', 'N');
INSERT INTO `eorder` VALUES (183, 'xia', 30, 1, 'N', '2019-04-29 18:28:48', 'N');
INSERT INTO `eorder` VALUES (184, 'xia', 15, 1, 'Y', '2019-04-29 18:29:00', 'N');
INSERT INTO `eorder` VALUES (185, 'zhang', 1, 1, 'Y', '2019-05-12 13:11:17', 'N');
INSERT INTO `eorder` VALUES (186, 'zhang', 4, 1, 'N', '2019-04-29 19:38:13', 'N');
INSERT INTO `eorder` VALUES (187, 'zhang', 7, 1, 'Y', '2019-04-29 19:39:47', 'N');
INSERT INTO `eorder` VALUES (188, 'zhang', 10, 1, 'Y', '2019-04-29 19:39:47', 'N');
INSERT INTO `eorder` VALUES (189, 'zhang', 11, 1, 'Y', '2019-05-12 13:11:17', 'N');
INSERT INTO `eorder` VALUES (190, 'hello', 1, 14, 'Y', '2019-04-29 20:11:43', 'N');
INSERT INTO `eorder` VALUES (191, 'hello', 2, 46, 'N', '2019-04-29 20:11:34', 'N');
INSERT INTO `eorder` VALUES (192, '5401', 1, 1, 'Y', '2019-04-29 20:44:33', 'N');
INSERT INTO `eorder` VALUES (193, '5401', 2, 1, 'Y', '2019-04-29 20:44:33', 'N');
INSERT INTO `eorder` VALUES (194, 'zhang', 7, 1, 'Y', '2019-05-12 13:11:17', 'N');
INSERT INTO `eorder` VALUES (195, 'zhang', 2, 1, 'N', '2019-05-12 13:10:52', 'N');

-- ----------------------------
-- Table structure for euser
-- ----------------------------
DROP TABLE IF EXISTS `euser`;
CREATE TABLE `euser`  (
  `user_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '123456@ebook',
  `phone` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `islogin` tinyint(4) NULL DEFAULT 0,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `disabled` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'N',
  PRIMARY KEY (`user_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of euser
-- ----------------------------
INSERT INTO `euser` VALUES ('5401', '1', NULL, NULL, 0, '1@qq.com', 'N');
INSERT INTO `euser` VALUES ('administrator', '110120119', '176********', '上海市***区***街道***', 0, '2625666138@qq.com', 'N');
INSERT INTO `euser` VALUES ('changqing', 'chang', '176********', '上海市***区***街道***', 0, 'changqing@qq.com', 'N');
INSERT INTO `euser` VALUES ('fahai', 'fahaibudongai', NULL, NULL, 0, 'fahai@qq.com', 'N');
INSERT INTO `euser` VALUES ('he', '000000', '176********', '上海市***区***街道***', 0, '2332@qq.com', 'N');
INSERT INTO `euser` VALUES ('hello', '1', NULL, NULL, 0, '1@qq.com', 'N');
INSERT INTO `euser` VALUES ('kiki', 'kikilove', '176********', '上海市***区***街道***', 0, 'kiki@163.com.cn', 'N');
INSERT INTO `euser` VALUES ('lala', 'lala', '176********', '上海市***区***街道***', 0, 'lala@163.com', 'N');
INSERT INTO `euser` VALUES ('lxx', '1', '176********', '上海市***区***街道***', 0, 'lxx@qq.com', 'N');
INSERT INTO `euser` VALUES ('mingTian', 'mingtian', NULL, NULL, 0, 'mingTian@foot.com', 'N');
INSERT INTO `euser` VALUES ('qiuya', 'quiya123', NULL, NULL, 0, 'qiuya@mingtian.com', 'N');
INSERT INTO `euser` VALUES ('tailler', 'tailler000', NULL, NULL, 0, 'tailler@qq.com', 'N');
INSERT INTO `euser` VALUES ('wang', 'wang123456', '176********', '上海市***区***街道***', 0, 'wang@123.com', 'N');
INSERT INTO `euser` VALUES ('xia', 'xia', NULL, NULL, 0, '222@qq.com', 'N');
INSERT INTO `euser` VALUES ('xiaxiao', 'qwertyuiop', '176********', '上海市***区***街道***', 0, '2625666138@qq.com', 'N');
INSERT INTO `euser` VALUES ('ZeTianJi', 'JUZU', NULL, NULL, 0, 'JUZU@163.com', 'N');
INSERT INTO `euser` VALUES ('zhang', 'zhang0', '176********', '上海市***区***街道***', 0, 'zhang@qq.com', 'N');
INSERT INTO `euser` VALUES ('zuofei', 'zuofei123', '176********', '上海市***区***街道***', 0, 'zuofei@163.com', 'N');
INSERT INTO `euser` VALUES ('zuoriqingkong', 'zuoriqingkong', NULL, NULL, 0, 'zrqk@qq.com', 'N');

-- ----------------------------
-- Table structure for language
-- ----------------------------
DROP TABLE IF EXISTS `language`;
CREATE TABLE `language`  (
  `language_id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT,
  `language_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`language_id`) USING BTREE,
  UNIQUE INDEX `language_name`(`language_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of language
-- ----------------------------
INSERT INTO `language` VALUES (1, 'Chinese');
INSERT INTO `language` VALUES (2, 'English');

-- ----------------------------
-- Table structure for logo
-- ----------------------------
DROP TABLE IF EXISTS `logo`;
CREATE TABLE `logo`  (
  `logo_id` int(10) UNSIGNED NOT NULL,
  `logo_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`logo_id`) USING BTREE,
  UNIQUE INDEX `logo_name`(`logo_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of logo
-- ----------------------------
INSERT INTO `logo` VALUES (4096, 'Web');
INSERT INTO `logo` VALUES (65536, '亲情');
INSERT INTO `logo` VALUES (8192, '冒险');
INSERT INTO `logo` VALUES (512, '名著');
INSERT INTO `logo` VALUES (1024, '小说');
INSERT INTO `logo` VALUES (16384, '教育');
INSERT INTO `logo` VALUES (256, '散文');
INSERT INTO `logo` VALUES (4, '数据库');
INSERT INTO `logo` VALUES (2048, '文学');
INSERT INTO `logo` VALUES (1, '本科教学');
INSERT INTO `logo` VALUES (8, '热门技术');
INSERT INTO `logo` VALUES (32768, '爱情');
INSERT INTO `logo` VALUES (64, '生活');
INSERT INTO `logo` VALUES (128, '科学');
INSERT INTO `logo` VALUES (32, '科普');
INSERT INTO `logo` VALUES (16, '程序');
INSERT INTO `logo` VALUES (262144, '艺术');
INSERT INTO `logo` VALUES (2, '计算机');
INSERT INTO `logo` VALUES (131072, '青春');

-- ----------------------------
-- Table structure for press
-- ----------------------------
DROP TABLE IF EXISTS `press`;
CREATE TABLE `press`  (
  `press_id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT,
  `press_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`press_id`) USING BTREE,
  UNIQUE INDEX `press_name`(`press_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of press
-- ----------------------------
INSERT INTO `press` VALUES (9, ' 中信出版社');
INSERT INTO `press` VALUES (13, '中国青年出版社');
INSERT INTO `press` VALUES (4, '人民文学出版社');
INSERT INTO `press` VALUES (15, '人民邮电出版社');
INSERT INTO `press` VALUES (11, '北京十月文艺出版社');
INSERT INTO `press` VALUES (6, '后浪 | 四川人民出版社');
INSERT INTO `press` VALUES (1, '后浪 | 湖南美术出版社');
INSERT INTO `press` VALUES (7, '后浪丨四川文艺出版社');
INSERT INTO `press` VALUES (10, '广西师范大学出版社');
INSERT INTO `press` VALUES (2, '机械工业出版社');
INSERT INTO `press` VALUES (8, '江苏凤凰文艺出版社');
INSERT INTO `press` VALUES (5, '浙江文艺出版社');
INSERT INTO `press` VALUES (14, '清华大学出版社');
INSERT INTO `press` VALUES (3, '湖南文艺出版社');
INSERT INTO `press` VALUES (16, '电子工业出版社');
INSERT INTO `press` VALUES (12, '长江文艺出版社');

-- ----------------------------
-- Table structure for writer
-- ----------------------------
DROP TABLE IF EXISTS `writer`;
CREATE TABLE `writer`  (
  `writer_id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `writer_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `introduce` varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`writer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of writer
-- ----------------------------
INSERT INTO `writer` VALUES (1, '木部石', '木部石（Kazu Kibushi），《纽约时报》畅销书排行榜第一名《护身符》系列的创作者。他创办并编辑了饱受赞誉《飞行》合集，近期为《哈利•波特》系列15周年平装纪念版设计并绘制了封面。木部和与妻子艾米•金•木部和孩子们一起，在华盛顿州的西雅图工作和生活。');
INSERT INTO `writer` VALUES (2, '李旭天', NULL);
INSERT INTO `writer` VALUES (3, 'Randal E.Bryant', 'Randal E. Bryant，1981年于麻省理工学院获得计算机博士学位，1984年至今一直任教于卡内基-梅隆大学。现任卡内基-梅隆大学计算机科学学院院长、教授，同时还受邀任教于电子和计算机工程系。他从事本科生和研究生计算机系统方面课程的教学近40年。他和O’Hallaron教授一起在卡内基梅隆大学开设了15-213课程“计算机系统导论”，那便是本书的基础。他还是ACM院士、IEEE院士、美国国家工程院院士和美国人文与科学研究院院士。其研究成果被Intel、IBM、Fujitsu和Microsoft等主要计算机制造商使用，他还因研究获得过Semiconductor Research Corporation、ACM、IEEE颁发的多项大奖。');
INSERT INTO `writer` VALUES (4, 'David O\'Hallaron', 'David R. O’Hallaron卡内基梅隆大学电子和计算机工程系教授。在弗吉尼亚大学（University of Virginia）获得计算机科学的博士学位，2007年-2010年为Intel匹兹堡实验室主任。他教授本科生和研究生的计算机系统方面的课程已有20余年，并和Bryant教授一起开设了“计算机系统导论”课程。曾获得CMU计算机学院颁发的Herbert Simon杰出教学奖。他主要从事计算机系统领域的研究，与Quake项目成员一起获得过高性能计算领域中的*高国际奖项——Gordon Bell奖。他目前的工作重点是研究自动分级（autograding）概念，即评价其他程序质量的程序。');
INSERT INTO `writer` VALUES (5, '龚奕利', NULL);
INSERT INTO `writer` VALUES (6, '贺莲', NULL);
INSERT INTO `writer` VALUES (7, '雷迎春', NULL);
INSERT INTO `writer` VALUES (8, 'Abraham Silberschatz', '  Abraham Silberschatz\n  于纽约州立大学石溪分校获得博士学位，现为耶鲁大学计算机科学Sidney J. Weinberg教授，计算机科学系主任，曾任贝尔实验室信息科学研究中心副主任。他是ACM Fellow 和 IEEE Fellow，曾获得IEEE Taylor L. Booth 教育奖、 ACM Karl V. Karlstrom 杰出教育者奖、ACM SIGMOD 贡献奖和IEEE 计算机学会杰出论文奖。他的研究兴趣包括操作系统、数据库系统、存储系统、网络管理和分布式系统。');
INSERT INTO `writer` VALUES (9, 'Henry F. Korth', '  Henry F. Korth\n  于普林斯顿大学获得博士学位，现为利哈伊大学计算机科学与工程系Weiseman教授，曾任贝尔实验室数据库原理研究中心主任。他是ACM Fellow 和 IEEE Fellow，是VLDB 10年贡献奖的获得者。他的研究兴趣包括为现代计算架构（多核、多线程、多级缓存）设计的数据库算法、基于Web的大型数据仓储、实时数据库系统和并行系统。');
INSERT INTO `writer` VALUES (10, 'S. Sudarshan', '  S. Sudarshan\n  于威斯康星大学麦迪逊分校获得博士学位，现为印度理工学院计算机科学与工程系教授，曾为贝尔实验室数据库研究组技术人员。他的研究兴趣包括查询处理和优化、关系数据和图结构数据的关键字查询，以及构建和测试数据库应用系统的工具。');
INSERT INTO `writer` VALUES (11, '杨冬青', '杨冬青\n  1969年毕业于北京大学数学力学系数学专业，现任北京大学信息科学技术学院教授，博士生导师，中国计算机学会数据库专委会委员。多年来承担并完成973、863、国家科技攻关、国家自然科学基金等多项国家重点科研项目，曾获国家科技进步二等奖、三等奖和多项省部级奖励，在国内外杂志及会议上发表论文百余篇，著译作十余部。目前主要研究方向为数据库系统实现技术、Web环境下的信息集成与共享、数据仓库和数据挖掘等。');
INSERT INTO `writer` VALUES (12, '李红燕', '  李红燕\n  1999年毕业于西北工业大学计算机科学与工程系计算机应用专业，获工学博士学位，现任北京大学信息科学技术学院教授，博士生导师，中国计算机学会数据库专委会委员。多年来承担并完成多项国家自然科学基金课题以及医疗、移动通信等典型应用领域内的应用研究项目，在国内外学术期刊及会议上发表论文90余篇，出版学术专著和教材各1部。目前主要研究方向为数据库系统与智能信息系统、数据仓库与数据挖掘、业务流程控制、云数据管理等。');
INSERT INTO `writer` VALUES (13, '唐世渭', '  唐世渭\n  1964年毕业于北京大学数学力学系计算数学专业，毕业后留校任教至今，现为北京大学信息科学技术学院教授，博士生导师，中国计算机学会数据库专委会委员，中国软件行业协会数据库及应用软件分会理事长。多年来承担并完成973、863、国家科技攻关、国家自然科学基金等多项国家重点科研项目，曾获国家科技进步二等奖、三等奖各1项，省部级科技进步奖多项，在国内外杂志及会议上发表论文百余篇，著译作多部。目前主要研究方向为数据库系统、数据仓库和数据挖掘、Web环境下的信息集成与共享、典型应用领域的信息系统等。');
INSERT INTO `writer` VALUES (14, '北野武', '  北野武\n日本著名导演、演员、作家。\n  1947年出生于日本东京。26岁成为漫才演员，以其无厘头的辛辣和黑色幽默成为20世纪80年代日本喜剧热潮的灵魂人物。后涉足广播电视、出版、绘画、时尚、音乐等，在电影领域更是享誉世界。主要电影作品包括《花火》《坏孩子的天空》《菊次郎的夏天》等。主要文字作品有《浅草小子》《毒舌北野武》《菊次郎与佐纪》等。\n  译者——王秀娟\n  毕业于上海外国语大学研究生院，现就职于天津商业大学外国语学院。译有林真理子的《平民之宴》等。');
INSERT INTO `writer` VALUES (15, '王秀娟', NULL);
INSERT INTO `writer` VALUES (16, '青崎有吾', '青崎有吾，1991年生，作家。2012年，凭借《体育馆之谜》获得第22届鮎川哲也奖。2014年，《水族馆之谜》获得本格推理大奖第二名。以超缜密的思维方式被誉为“日本奎因”');
INSERT INTO `writer` VALUES (17, '沈熹', NULL);
INSERT INTO `writer` VALUES (18, '  Fay Weldon', '费伊·韦尔登（Fay Weldon, 1931— ）\r\n  英国小说家、剧作家、编剧，大英帝国勋章获得者、英国皇家文学学会会员。出生于英格兰，成长于新西兰，受教育于苏格兰。从事小说写作之前，是个成功的广告策划人。曾担任1983年布克奖评委会主席。\r\n  创作有：\r\n 三十四部长篇小说，其中《食戒》（The Fat Woman’s Joke, 1967）为其处女作，《爱界》（Praxis, 1978）入围布克奖决选名单，《女魔头的人生与爱情》（The Life and Loves of a She Devil, 1983）被BBC改编为电视剧，好莱坞改编为电影；\r\n 一部广受关注的回忆录《费伊自传》（Auto da Fay, 2002）；\r\n 五部短篇小说集，包括《恶女》（Wicked Women, 1996）等；\r\n 大量电视剧本、广播剧本，《楼上楼下》（Upstairs, Downstairs, 1971）首集剧本曾获英国编剧协会“最佳电视剧剧本奖”。\r\n韦尔登在作品中探讨两性关系，关注弱势一方，展现勇气。她记录时代，极少说教，将人生阅历写进作品。她的作品从不缺乏关注，总会受到热议。');
INSERT INTO `writer` VALUES (19, '肖丽媛', NULL);
INSERT INTO `writer` VALUES (20, '叶小辛', '叶小辛，上海交通大学毕业，曾为业余翻译、媒体人，目前任职于民航。2015年开始在豆瓣阅读写作，以其生动大方且真实感人的写作方式迅速赢得读者喜爱，发表作品逾百万字，其中，《空港》一举斩获第四届豆瓣阅读征文大赛职业女性故事组首奖以及新丽传媒特别奖两项大奖。已出版《原来你是这样的欧洲史》。');
INSERT INTO `writer` VALUES (21, '大山旬', '  大山旬，日本超人气形象设计师。他长期致力于为普通人提供一读便懂的“穿衣法则”，教授实用穿搭术。曾经因为手把手成功改造众多日本普通人而被读卖新闻、日本放送协会、朝日电视台和 TBS 电视台广为报道，在日本享有极高的声誉。');
INSERT INTO `writer` VALUES (22, '肖潇', NULL);
INSERT INTO `writer` VALUES (23, '陈思安', '  陈思安，小说家、诗人、戏剧编导，现居北京。出版有中短篇小说集《天马行空那些年》《接下来，我问，你答》；导演舞台剧作品《随黄公望游富春山》《吃火》《沉默的间隔》等。借鉴诗歌、戏剧等艺术，在创作手法上多有突破之举，形成了具有实验探索性质的文本。');
INSERT INTO `writer` VALUES (24, '苏美', '  苏美，长于新疆，现居青岛，学德文，现任职于青岛某大学。在读者眼中，“这个女教授看起来很好吃”。寥寥数语，直指人心，著有畅销书《倾我所有去生活》《文艺女青年这种病，生个孩子就好了》。');
INSERT INTO `writer` VALUES (25, 'Terry Eagleton', '  特里·伊格尔顿（Terry Eagleton），生于1943年，英国著名文学理论家、批评家。出版著作超过四十本，代表作有《权力的神话》（1975）《批评与意识形态》（1976）《文学理论：导论》（1983）《批评的功能》（1984）《美学意识形态》（1990）《理论之 后》（2003）《理性，信仰，革命》（2009）《马克思为什么是对的》（2011）《文学事件》（2012）《激进的牺牲》（2018）。凭借深厚广博的学识和独树一帜的批评，伊格尔顿不论在文学研究者还是爱好者那里，都具有无可替代的崇高地位。');
INSERT INTO `writer` VALUES (26, '高晓玲', '高晓玲，北京大学文学博士，郑州大学外语学院教授，英国剑桥大学访问学者。译有《文化与社会》。');
INSERT INTO `writer` VALUES (27, '龙应台', '  龙应台\r\n  台湾乡下的自来水厂里出生，渔村农村长大。留学美国九年，旅居欧洲十三年，任教于香港九年。两度进入政府，担任公职。\r\n是一支独立的笔——可以烧灼如野火，狂放如江海，也可以温润如目送。\r\n  二〇一四年十二月一日辞官，回到“文人安静的书桌”。\r\n  二〇一五年九月担任香港大学“孔梁巧玲杰出人文学者”至今。\r\n  二〇一七年八月移居屏东潮州镇，照顾母亲，开始乡居写作。\r\n	  龙应台，1952年生于台湾，华人世界率性犀利的一枝笔，33岁着手写《野火集》抨击时弊，21天内再版24次，对台湾甚至大陆发生深远的影响。34岁第一次做母亲，自称从此开始上“人生课”，且至今未毕业——龙应台“人生三书”《孩子你慢慢来》、《亲爱的安德烈》、《目送》，是这堂“人生课”中的三本“作业”。');
INSERT INTO `writer` VALUES (28, '三毛', '  三毛，台湾著名作家，1943年3月26日出生于重庆，浙江省定海县人。本名为陈懋平，1946年改名陈平，笔名“三毛”，1964年进入文化大学哲学系，肄业后曾留学欧洲，婚后定居西属撒哈拉沙漠加那利岛，并以当地的生活为背景，写出一连串情感真挚的作品。1981年回到台湾，曾在文化大学任教，1984年辞去教职，专职从事写作和演讲，1991年1月4日去世，享年48岁。');
INSERT INTO `writer` VALUES (29, '余秋雨', '\r\n  余秋雨，浙江余姚人，当代著名散文家，文化学者，艺术理论家，文化史学家。著有《文化苦旅》《何谓文化》《中国文脉》《山河之书》《霜冷长河》等。\r\n  二十世纪八十年代中期，他被推举为当时中国内地最年轻的高校校长，并出任上海市中文专业教授评审组组长，兼艺术专业教授评审组组长。二十多年前，他毅然辞去一切行政职务和高位任命，孤身一人寻访中华文明被埋没的重要遗址。\r\n  二十世纪末，冒着生命危险贴地穿越数万公里考察了巴比伦文明、埃及文明、克里特文明、希伯莱文明、阿拉伯文明、印度文明、波斯文明等一系列最重要的文化遗迹，作为迄今全球唯一完成全部现场文化探索的人文学者，对当代世界文明作出了全新思考和紧迫提醒，在海内外引起广泛关注。\r\n  他所写的书籍，长期位居全球华文书排行榜前列，仅中国台湾一地，就囊括了白金作家奖、桂冠文学家奖、读书人最佳书奖、金石堂最有影响力书奖等一系列重大奖项。');
INSERT INTO `writer` VALUES (30, '林海音', '  林海音（1918-2001），现代女作家。她原籍台湾苗栗，生于日本，长于北京。1960年以小说《城南旧事》成名。林海音不仅创作了许多小说和散文作品，她在出版业上亦有许多成绩。从1951年开始，她主编《联合报》副刊10年，树立了编辑的典范，提升了文艺副刊的水准和地位；1961年创办“纯文学出版社”，发掘鼓励许许多多的年轻作家。');
INSERT INTO `writer` VALUES (31, '刘忆智', '  刘忆智，毕业于浙江大学软件学院。长期从事Linux服务器维护工作，拥有多年的服务器维护经验。担任浙江大学求是潮网站的技术总监，领导并参与了问答堂、学习资源平台等Web项目的开发工作。组织策划了网站第5次首页改版。2008年为浙江大学党委组织部设计并开发了干部人才培训系统。');
INSERT INTO `writer` VALUES (32, '上野宣', '  上野 宣\r\n  OWASP 日本分会会长，TRICORDER株式会社董事长。\r\n  主要从事安全咨询、风险评估、信息安全教育等工作。著有《今晚我们一起学习邮件协议》（今夜わかるメールプロトコル）、《今晚我们一起学习TCP/IP》（今夜わかるTCP/IP）、《今晚我们一起学习HTTP》（今夜わかるHTTP）。担任The Tangled Web:A Guide to Securing Modern Web Application日文版的审校工作。');
INSERT INTO `writer` VALUES (33, '于均良', '  上海交通大学硕士，高级软件工程师，马拉松跑者，四点网创始人。');
INSERT INTO `writer` VALUES (34, 'Brian W. Kernighan', '  Brian W. Kernighan： 贝尔实验室计算科学研究中心高级研究人员，著名的计算机科学家。他参加了UNIX系统、C语言、AWK语言和许多其他系统的开发，同时出版了许多在计算机领域具有影响的著作，如《The Elements of Programming Style》、《The Practice of Programming》、《The UNIX Programming Environment》、《The AWK Language》、《Software Tools》等。');
INSERT INTO `writer` VALUES (35, 'Dennis M. Ritchie', '  Dennis M. Ritchie：1967年加入贝尔实验室。他和Ken L. Thompson两人共同设计并实现的C语言改变了程序设计语言发展的轨迹，是程序设计语言发展过程中的一个重要里程碑。与此同时，他们两人还设计并实现了UNIX操作系统。正是由于这两项巨大贡献，Dennis M. Ritchie于1983年获得了计算机界的最高奖——图灵奖。此外，他还获得了ACM、IEEE、贝尔实验室等授予的多种奖项。');
INSERT INTO `writer` VALUES (36, '徐宝文', NULL);
INSERT INTO `writer` VALUES (37, '李志', NULL);
INSERT INTO `writer` VALUES (38, 'Bruce Eckel', '  Bruce Eckel是MindView公司（www.MindView.net）的总裁，该公司向客户提供软件咨询和培训。他是C++标准委员会拥有表决权的成员之一，拥有应用物理学学士和计算机工程硕士学位。除本书外，他还是《C++编程思想》的作者，并与人合著了《C++编程思想第2卷》（这两本书的英文影印版及中文版均已由机械工业出版社引进出版）及其他著作。他已经发表了150多篇论文，还经常参加世界各地的研讨会并进行演讲。');
INSERT INTO `writer` VALUES (39, '陈昊鹏', NULL);
INSERT INTO `writer` VALUES (40, 'Vamei', '  作者曾从事高性能运算方面的研究，现从事智能硬件方面的创业。个人技术博客点击量超600万，写作有多个编程教程。');
INSERT INTO `writer` VALUES (41, 'Andrew Hunt', NULL);
INSERT INTO `writer` VALUES (42, 'David Thomas', NULL);
INSERT INTO `writer` VALUES (43, '马维达', NULL);
INSERT INTO `writer` VALUES (44, 'François Chollet', '弗朗索瓦•肖莱（François Chollet）\r\n  Keras之父，TensorFlow机器学习框架贡献者，Kaggle竞赛教练，个人Kaggle竞赛全球排名曾获得第17名。目前任职于Google，从事人工智能研究，尤其关注计算机视觉与机器学习在形式推理方面的应用。');
INSERT INTO `writer` VALUES (45, '张亮', '张亮（hysic）\r\n  毕业于北京大学物理学院，爱好机器学习和数据分析的核安全工程师，译有《Python数据处理》《Python机器学习基础教程》等。');
INSERT INTO `writer` VALUES (46, '斋藤康毅', '  斋藤康毅\r\n  东京工业大学毕业，并完成东京大学研究生院课程。现从事计算机视觉与机器学习相关的研究和开发工作。是Introducing Python、Python in Practice、The Elements of Computing Systems、Building Machine Learning Systems with Python的日文版译者。');
INSERT INTO `writer` VALUES (47, '陆宇杰', '  众安科技NLP算法工程师。主要研究方向为自然语言处理及其应用，对图像识别、机器学习、深度学习等领域有密切关注。Python爱好者。');
INSERT INTO `writer` VALUES (48, '尤瓦尔·赫拉利', '  尤瓦尔·赫拉利，1976年生，牛津大学历史学博士，现为耶路撒冷希伯来大学的历史系教授，青年怪才，全球瞩目的新锐历史学家。\r\n  他擅长世界历史和宏观历史进程研究。在学术领域和大众出版领域都有很大的兴趣。\r\n  他的《人类简史》一书让他一举成名，成为以色列超级畅销书，目前这本书已授20多个国家版权，在历史学之外，人类学、生态学、基因学等领域的知识信手拈来，根据图书改变的课程上传YOUTUBE后风靡全球，拥有大批青年粉丝。写书，视频课程之外，他还开设有专栏。');
INSERT INTO `writer` VALUES (49, '林俊宏', NULL);

-- ----------------------------
-- View structure for allbooks
-- ----------------------------
DROP VIEW IF EXISTS `allbooks`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `allbooks` AS select `book`.`book_id` AS `book_id`,`book`.`book_name` AS `book_name`,`book`.`subtitle` AS `subtitle`,`a`.`writer_name` AS `author_name`,`t`.`writer_name` AS `translator_name`,`press`.`press_name` AS `press_name`,`book`.`version` AS `version`,`language`.`language_name` AS `language_name`,`book`.`cover` AS `cover`,`book`.`price` AS `price`,`book`.`inventory` AS `inventory`,`book`.`saled` AS `saled`,`book`.`onsale` AS `onsale`,`book`.`score` AS `score`,`book`.`ISBN` AS `ISBN`,`getLogos`(`book`.`logo`) AS `logos`,`book`.`detail` AS `detail`,`a1`.`writer_name` AS `author1_name`,`a2`.`writer_name` AS `author2_name`,`a3`.`writer_name` AS `author3_name`,`t1`.`writer_name` AS `translator1_name`,`t2`.`writer_name` AS `translator2_name`,`t3`.`writer_name` AS `translator3_name`,`a`.`introduce` AS `author_detail`,`a1`.`introduce` AS `author1_detail`,`a2`.`introduce` AS `author2_detail`,`a3`.`introduce` AS `author3_detail`,`t`.`introduce` AS `translator_detail`,`t1`.`introduce` AS `translator1_detail`,`t2`.`introduce` AS `translator2_detail`,`t3`.`introduce` AS `translator3_detail` from ((((((((((`book` join `language` on((`book`.`lang` = `language`.`language_id`))) join `press` on((`book`.`publish` = `press`.`press_id`))) left join `writer` `a` on((`book`.`author` = `a`.`writer_id`))) left join `writer` `a1` on((`book`.`with_author1` = `a1`.`writer_id`))) left join `writer` `a2` on((`book`.`with_author2` = `a2`.`writer_id`))) left join `writer` `a3` on((`book`.`with_author3` = `a3`.`writer_id`))) left join `writer` `t` on((`book`.`translator` = `t`.`writer_id`))) left join `writer` `t1` on((`book`.`with_translate1` = `t1`.`writer_id`))) left join `writer` `t2` on((`book`.`with_translate2` = `t2`.`writer_id`))) left join `writer` `t3` on((`book`.`with_translate3` = `t3`.`writer_id`)));

-- ----------------------------
-- View structure for allorder
-- ----------------------------
DROP VIEW IF EXISTS `allorder`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `allorder` AS with `personalorder` as (select `eorder`.`order_id` AS `order_id`,`eorder`.`user_name` AS `user_name`,`eorder`.`book_id` AS `book_id`,`eorder`.`book_num` AS `book_num`,`eorder`.`time` AS `time`,`eorder`.`chosen` AS `chosen` from `eorder` where (`eorder`.`paid` = 'Y')) select `personalorder`.`order_id` AS `order_id`,`personalorder`.`book_id` AS `book_id`,`book`.`book_name` AS `book_name`,`personalorder`.`user_name` AS `user_name`,`personalorder`.`book_num` AS `book_num`,`book`.`subtitle` AS `subtitle`,`language`.`language_name` AS `language_name`,`book`.`version` AS `version`,`book`.`price` AS `price`,`book`.`ISBN` AS `ISBN`,`book`.`cover` AS `cover`,`personalorder`.`time` AS `time` from ((`personalorder` join `book` on((`personalorder`.`book_id` = `book`.`book_id`))) join `language` on((`book`.`lang` = `language`.`language_id`)));

-- ----------------------------
-- View structure for allordertopaid
-- ----------------------------
DROP VIEW IF EXISTS `allordertopaid`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `allordertopaid` AS with `personalorder` as (select `eorder`.`order_id` AS `order_id`,`eorder`.`user_name` AS `user_name`,`eorder`.`book_id` AS `book_id`,`eorder`.`book_num` AS `book_num`,`eorder`.`time` AS `time`,`eorder`.`chosen` AS `chosen` from `eorder` where (`eorder`.`paid` = 'N')) select `personalorder`.`order_id` AS `order_id`,`personalorder`.`chosen` AS `chosen`,`personalorder`.`book_id` AS `book_id`,`book`.`book_name` AS `book_name`,`personalorder`.`user_name` AS `user_name`,`personalorder`.`book_num` AS `book_num`,`book`.`subtitle` AS `subtitle`,`language`.`language_name` AS `language_name`,`book`.`version` AS `version`,`book`.`price` AS `price`,`book`.`ISBN` AS `ISBN`,`book`.`cover` AS `cover`,`personalorder`.`time` AS `time` from ((`personalorder` join `book` on((`personalorder`.`book_id` = `book`.`book_id`))) join `language` on((`book`.`lang` = `language`.`language_id`)));

-- ----------------------------
-- View structure for alluser
-- ----------------------------
DROP VIEW IF EXISTS `alluser`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `alluser` AS select `euser`.`user_name` AS `user_name`,`euser`.`phone` AS `phone`,`euser`.`address` AS `address`,`euser`.`email` AS `email`,`euser`.`disabled` AS `disabled` from `euser`;

-- ----------------------------
-- View structure for bookbrowse
-- ----------------------------
DROP VIEW IF EXISTS `bookbrowse`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `bookbrowse` AS select `allbooks`.`book_id` AS `book_id`,`allbooks`.`book_name` AS `book_name`,`allbooks`.`subtitle` AS `subtitle`,`allbooks`.`cover` AS `cover`,`allbooks`.`author_name` AS `author_name`,`allbooks`.`author1_name` AS `author1_name`,`allbooks`.`author2_name` AS `author2_name`,`allbooks`.`author3_name` AS `author3_name`,`allbooks`.`ISBN` AS `ISBN`,`allbooks`.`inventory` AS `inventory`,`allbooks`.`onsale` AS `onsale` from `allbooks`;

-- ----------------------------
-- View structure for orderstatistics
-- ----------------------------
DROP VIEW IF EXISTS `orderstatistics`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `orderstatistics` AS select `allorder`.`user_name` AS `user_name`,`allorder`.`time` AS `time`,sum(`allorder`.`book_num`) AS `book_number`,sum((`allorder`.`book_num` * `allorder`.`price`)) AS `money` from `allorder` group by `allorder`.`user_name`,`allorder`.`time`;

-- ----------------------------
-- Function structure for addBook
-- ----------------------------
DROP FUNCTION IF EXISTS `addBook`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `addBook`(uname varchar(40), oid bigint, addition int) RETURNS int(11)
begin
 declare nm varchar(40) default null;
 declare bnum int;
 declare inv int;
 select user_name, book_num into nm, bnum
 from eorder
 where order_id=oid;
 
 select inventory into inv
 from book
 where book_id=(select book_id from allOrderToPaid where order_id=oid);
 
 if nm is null or nm<>uname then return 0;
 else 
   begin
    if bnum+addition<=0 then set bnum=1;
		elseif bnum+addition>=inv then set bnum=inv;
	  else set bnum=bnum+addition;
    end if;
    update eorder
     set book_num=bnum, time=now()
	   where order_id=oid;
	 end;
 end if;
return bnum;
end
;;
delimiter ;

-- ----------------------------
-- Function structure for addOrder
-- ----------------------------
DROP FUNCTION IF EXISTS `addOrder`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `addOrder`(uname varchar(40), add_bid int) RETURNS int(11)
begin
  declare bid int default null;
	declare ons char(1)default null;
	declare oid bigint default null;
	declare pri float(6,2);
  select book_id, onsale into bid, ons
	  from book 
	  where book_id=add_bid;
  if bid is null then return -1;
	elseif ons='N' then return 0;
  end if;
	select order_id into oid 
	  from eorder
	 	where user_name=uname and book_id=add_bid and paid='N';
	if oid is null then 
	  insert eorder(user_name, book_id, time)
	    values(uname, add_bid, now());
	end if;		 
  return 1;
end
;;
delimiter ;

-- ----------------------------
-- Function structure for checkOrder
-- ----------------------------
DROP FUNCTION IF EXISTS `checkOrder`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `checkOrder`(uname varchar(40)) RETURNS int(11)
begin
  with o as(
	  select book_id, book_num, inventory
		from (select book_id, book_num
		        from eorder
						where user_name=uname and paid="N" and chosen="Y") as t1 natural join book)
	update eorder join o on eorder.book_id=o.book_id
	  set eorder.book_num=(case eorder.book_num
		                       when eorder.book_num <= o.inventory then eorder.book_num
													 else o.inventory
												 end)
		 where user_name<>uname;
		 
	 delete from eorder
	 where book_num<=0;
	 return 1;
end
;;
delimiter ;

-- ----------------------------
-- Function structure for checkUser
-- ----------------------------
DROP FUNCTION IF EXISTS `checkUser`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `checkUser`(uname varchar(40), upassword varchar(30)) RETURNS int(11)
begin
  declare n varchar(40) default null;
	declare p varchar(30) default null;
	declare dis char(1) default 'N';
	select user_name, user_password, disabled into n, p, dis
	  from euser
	  where user_name=uname;
	if n is null then 
	  return -2;
	elseif dis='Y' then
	  return -1;
	elseif(p!=upassword) then 
	  return 0;
	elseif(uname="administrator") then
	  return 2;
	else return 1;
	end if;
end
;;
delimiter ;

-- ----------------------------
-- Function structure for chooseAllOrder
-- ----------------------------
DROP FUNCTION IF EXISTS `chooseAllOrder`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `chooseAllOrder`(uname varchar(40), ch char(1)) RETURNS int(11)
begin
update eorder
  set chosen=ch
	where user_name=uname and paid='N';
return 1;
end
;;
delimiter ;

-- ----------------------------
-- Function structure for chooseOrder
-- ----------------------------
DROP FUNCTION IF EXISTS `chooseOrder`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `chooseOrder`(uname varchar(40), oid bigint, ch char(1)) RETURNS int(11)
begin

declare nm varchar(40);
declare pd char(1);
select user_name, paid into nm, pd
  from eorder 
	where order_id=oid;
if nm<>uname then return -1;
elseif pd='Y' then return 0;
else update eorder
       set chosen=ch
			 where order_id=oid;
end if;
return 1;

end
;;
delimiter ;

-- ----------------------------
-- Function structure for deleteOrder
-- ----------------------------
DROP FUNCTION IF EXISTS `deleteOrder`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `deleteOrder`(uname varchar(40)) RETURNS int(11)
begin

delete from eorder
  where user_name=uname and paid='N' and chosen='Y';
return 1;

end
;;
delimiter ;

-- ----------------------------
-- Function structure for disableUser
-- ----------------------------
DROP FUNCTION IF EXISTS `disableUser`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `disableUser`(uname varchar(50)) RETURNS int(11)
begin
declare disa char(1) default null;
select disabled into disa from euser where user_name=uname;
if uname="administrator" then return 0;
elseif disa='N' then 
  update euser set disabled='Y' where user_name=uname;
elseif disa='Y' then 
	update euser set disabled='N' where user_name=uname;
else return -1;
end if;
return 1;

end
;;
delimiter ;

-- ----------------------------
-- Function structure for getLogos
-- ----------------------------
DROP FUNCTION IF EXISTS `getLogos`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getLogos`(logo_num integer) RETURNS varchar(100) CHARSET utf8
begin
  declare logos varchar(100) default "";
	declare l varchar(20);
	declare done int default false;
	declare cur cursor for
    select logo_name from logo where (logo_num & logo_id)<>0;
	declare continue handler for not found set done=true;
	open cur;
	repeat
	  fetch cur into l;
		if done != true then 
		  set logos=concat(logos, " ", l);
		end if;
	  until done
  end repeat;
	close cur;
	return ltrim(logos);
end
;;
delimiter ;

-- ----------------------------
-- Function structure for logoutUser
-- ----------------------------
DROP FUNCTION IF EXISTS `logoutUser`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `logoutUser`(uname varchar(40)) RETURNS int(11)
begin
  update euser 
	  set islogin=0
		where uname=user_name;
	return 1;
end
;;
delimiter ;

-- ----------------------------
-- Function structure for offOnSale
-- ----------------------------
DROP FUNCTION IF EXISTS `offOnSale`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `offOnSale`(bid int, offon char(1)) RETURNS int(11)
begin 
  update book
	  set onsale=offon
		where book_id=bid;
	return 1;
end
;;
delimiter ;

-- ----------------------------
-- Function structure for payOrder
-- ----------------------------
DROP FUNCTION IF EXISTS `payOrder`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `payOrder`(uname varchar(40)) RETURNS int(11)
begin
declare t varchar(20);
declare money float(6,2) default 0;
declare ck int;
select now() into t;
select sum(book_num*price) into money
from (select book_id, book_num
       from eorder
       where user_name=uname and paid='N' and chosen='Y') as o
		  natural join book;
			
with o as(
  select book_id, book_num
  from eorder
  where user_name=uname and paid='N' and chosen='Y')
update book natural join o
  set inventory=inventory-o.book_num, saled=saled+o.book_num
	where book.book_id=o.book_id;
	

select checkOrder(uname) into ck;

update eorder
  set paid='Y', time=t, chosen='N'
	where user_name=uname and chosen='Y' and paid='N';

return money;
end
;;
delimiter ;

-- ----------------------------
-- Function structure for registerUser
-- ----------------------------
DROP FUNCTION IF EXISTS `registerUser`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `registerUser`(uname varchar(40), upass varchar(30), uemail varchar(50)) RETURNS int(11)
begin
  declare n varchar(40) default null;
	if length(trim(uname))=0 then
	  return -1;
  elseif length(trim(upass))=0 then
	  return -2;
	elseif length(trim(uemail))=0 then
	  return -3;
	end if;
	select user_name into n
	  from euser
		where user_name=uname;
	if n is not null then return 0;
	end if;
  insert euser(user_name, user_password, email)
	  values(uname, upass, uemail);
	return 1;
	
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
