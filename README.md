# 새싹농부
<img width="1312" height="656" alt="image" src="https://github.com/user-attachments/assets/dcc97d67-6196-46b2-bc1e-3981370d5751" />

## 프로젝트 개요
새싹농부는 도시의 유휴 인력과 일손이 필요한 농장주를 연결해 주는 **농촌 일자리 매칭 및 정착 지원 플랫폼**입니다. <br>
단순한 인력 중개를 넘어, 농촌 생활에 관심 있는 도시민들이 안정적으로 농촌에 적응하고 정착할 수 있도록 교육과 소통의 장을 제공합니다.

## 기술 스택
![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) 
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white)

## 담당 기능
### 1. 농장 및 구인 공고 관리 시스템 (Farm & Work)
- **농장 프로필 등록 및 이미지 관리**: 농장주 사용자가 농장 이름, 주소, 재배 작물 등 상세 정보를 등록하는 API를 구현했습니다. 특히 Amazon S3를 연동하여 농장 전경 및 이미지 파일을 업로드하고 관리하는 기능을 포함합니다.
- **구인 공고 생성**: 모집 기간, 인원, 시급 및 일급, 근무 시간 등 세부 조건이 포함된 일자리 공고를 생성하고 관리할 수 있도록 설계했습니다.
- **조건별 일자리 필터링 검색**: 노동자가 자신에게 맞는 일자리를 쉽게 찾을 수 있도록 지역, 농업 구분, 작물, 경력 등 4가지 이상의 세부 조건을 조합한 필터링 검색 API를 구현했습니다.
- **통합 키워드 검색**: 공고 제목이나 내용 중 특정 키워드가 포함된 정보를 빠르게 찾아주는 검색 기능을 제공합니다.

### 2. 구직자 맞춤형 프로필 및 이력서 시스템 (Worker & Resume)
- **근로자 역량 기반의 검증된 매칭 프로필**: 구직자의 희망 지역, 관심 작물뿐만 아니라 보유한 수료증 및 뱃지 정보를 관리하여 농장주에게 신뢰도 높은 정보를 제공합니다.
- **이력서 관리**: 구직자가 자신의 경력과 자기소개를 관리하고 공고에 지원할 수 있는 기반 시스템을 구축했습니다.

### 3. 교육 및 커뮤니티 공간 (Board & Video)
- **정보 공유 게시판**: 농장주와 노동자, 혹은 도시 유휴 인력 간의 소통을 위한 게시판과 댓글 기능을 구현하여 커뮤니티 환경을 조성했습니다.
- **농업 교육 콘텐츠 연동**: 작물 재배 기술이나 농촌 생활 관련 영상 및 정책 정보를 제공하는 기능을 구현하여 사용자의 농촌 적응을 기술적으로 지원합니다.

### 4. 할 일 관리 및 사용자 인터랙션 (Todo & Interaction)
- **농장 및 근로자 할 일 관리**: 농장 운영이나 개인 작업 스케줄을 관리할 수 있는 Todo 시스템을 구축하여 업무 효율성을 높였습니다.
- **사용자 간 관계 형성 지원**: 리뷰 시스템을 통해 농장과 노동자 간의 상호 평가가 가능하도록 하여 신뢰 기반의 매칭을 지원합니다.
