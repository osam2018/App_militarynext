### 개요
```
국방개혁 2.0이 도래하면서 전 국군 장병이 핸드폰을 사용하게 될날이 머지 않아 다가오고 있다.
그렇지만 기존에 핸드폰을 사용하지 않았던 군인들을 위한 어플리케이션 서비스가 없다.
그래서 국군 장병들이 필요로 하는 어플리케이션 
```
### 기능
```
- 인증기능
    - 회원가입(군번 기반의 회원가입)
    - 로그인
    
- 장터마당(합리적인 소비)
    - 공동 구매(군인들이 공통적으로 필요한 물품들이 있음. ex) 단백질 보충제, mp3 플레이어 등 리스트 클릭시 해당 웹사이트 이동)
    - 중고 거래(전역 임박자들은 사용하던 군대용품을 판매할수 있고 신병들은 싸게 필요한 물품을 구하기 위해 필요함) 
    - 물품 팔기(자신의 물품을 직접 중고거래 마켓에 등록가능함.)
    
- 도서마당(군인 독서 장려)
    - 베스트셀러 순위열람 및 알라딘 구매링크 연결을 통한 해당상품 바로구매 가능
    - 후기(책들을 읽은 군인들의 후기를 보면서 자신이 볼만할 책을 찾을 수 있음
    - 다독 랭킹(많이 도서를 읽은 순서대로 랭킹을 나열함.
    
- 커뮤니티
    - 타임라인 보기
    - 타임라인 쓰기
    - 공지사항 보기(군인에게 필요한 정보를 내용과 함께 링크도 전달하여 클릭시 해당 링크로 이동가능)
    - 내가쓴글 보기(타임라인에서 내가 쓴글을 바로 볼수 있음)
    
    블라인드, 대나무숲같은 익명 커뮤니티가 많은 순기능(고민상담, 정보획득, 부조리 관습 제거)을 가져오면서 
    특정 그룹에 대한 익명커뮤니티에 필요성또한 커지고 있다. 군부대 내에 커뮤니티를 생성하면서 위와같은 순기능을 누림과 동시에
    SNS 사용욕구를 군대 내에서 풀게하면서 사회적으로 SNS를 오용에 대한 군기강 해이 및 군인에 대한 사회적 인식 손상방지를 이뤄낼수 있음.
    
- 부대마당(자신의 부대 생활 내에 편의성 도모)
    - 부대 공지사항 열람(작성된 부대 공지사항을 폰으로 수시로 확인할수 있어서 부대 전파사항을 효과적으로 확인가능)
    - 나의 부대 일정 열람(서버에서 그 날에 맞는 일정을 불러와서 푸쉬알람을 띄워줌으로써 자신의 역할을 숙지가능)
```

### 사용 라이브러리
```
Firebase-core
Firebase-RealtimeDatabase
Firebase-Crashytics
Firebase-Cloud-Message
Glide
Butterknife
Retrofit
```

### License
```
MIT License

Copyright (c) 2018 jo youngje

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
